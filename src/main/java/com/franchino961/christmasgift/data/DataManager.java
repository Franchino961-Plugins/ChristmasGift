package com.franchino961.christmasgift.data;

import com.franchino961.christmasgift.ChristmasGift;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * Gestisce il salvataggio e caricamento dei dati del plugin.
 * Mantiene traccia dei blocchi regalo e delle statistiche dei giocatori.
 * 
 * @author Franchino961
 * @version 1.4.0
 * @since 1.0.0
 */

public class DataManager {

    private final ChristmasGift plugin;
    private File dataFile;
    private FileConfiguration dataConfig;

    private final Map<Location, GiftBlock> giftBlocks = new HashMap<>();
    private final Map<UUID, Integer> playerStats = new HashMap<>();

    /**
     * Costruttore del DataManager.
     * 
     * @param plugin Istanza del plugin principale
     */
    public DataManager(ChristmasGift plugin) {
        this.plugin = plugin;
    }

    /**
     * Carica i dati dal file data.yml.
     * Gestisce blocchi regalo e statistiche giocatori.
     * Skippa automaticamente blocchi in world non esistenti.
     */

    public void loadData() {
        dataFile = new File(plugin.getDataFolder(), "data.yml");

        if (!dataFile.exists()) {
            try {
                dataFile.createNewFile();
                plugin.getLogger().info("Created new data.yml file");
            } catch (IOException e) {
                plugin.getLogger().severe("Could not create data.yml!");
                e.printStackTrace();
                return;
            }
        }

        dataConfig = YamlConfiguration.loadConfiguration(dataFile);

        // Load gift blocks
        if (dataConfig.contains("gift-blocks")) {
            ConfigurationSection giftBlocksSection = dataConfig.getConfigurationSection("gift-blocks");

            if (giftBlocksSection == null) {
                plugin.getLogger().warning("gift-blocks section is null, skipping gift blocks loading");
            } else {
                int loaded = 0;
                int skipped = 0;

                for (String key : giftBlocksSection.getKeys(false)) {
                    try {
                        String path = "gift-blocks." + key;
                        String worldName = dataConfig.getString(path + ".world");
                        double x = dataConfig.getDouble(path + ".x");
                        double y = dataConfig.getDouble(path + ".y");
                        double z = dataConfig.getDouble(path + ".z");
                        boolean claimed = dataConfig.getBoolean(path + ".claimed");
                        String claimedBy = dataConfig.getString(path + ".claimed-by");

                        // CRITICAL FIX: Check if world exists before creating Location
                        World world = plugin.getServer().getWorld(worldName);
                        if (world == null) {
                            plugin.getLogger().warning("Skipping gift block in non-existent world: " + worldName +
                                    " at coordinates (" + x + ", " + y + ", " + z + ")");
                            skipped++;
                            continue;
                        }

                        Location location = new Location(world, x, y, z);
                        UUID claimedById = claimedBy != null && !claimedBy.isEmpty() ? UUID.fromString(claimedBy)
                                : null;
                        GiftBlock giftBlock = new GiftBlock(location, claimed, claimedById);
                        giftBlocks.put(location, giftBlock);
                        loaded++;

                    } catch (Exception e) {
                        plugin.getLogger().warning("Error loading gift block " + key + ": " + e.getMessage());
                        skipped++;
                    }
                }

                plugin.getLogger().info("Loaded " + loaded + " gift blocks" +
                        (skipped > 0 ? " (skipped " + skipped + " invalid)" : ""));
            }
        }

        // Load player stats
        if (dataConfig.contains("player-stats")) {
            ConfigurationSection playerStatsSection = dataConfig.getConfigurationSection("player-stats");

            if (playerStatsSection == null) {
                plugin.getLogger().warning("player-stats section is null, skipping player stats loading");
            } else {
                int loaded = 0;

                for (String uuidString : playerStatsSection.getKeys(false)) {
                    try {
                        UUID uuid = UUID.fromString(uuidString);
                        int found = dataConfig.getInt("player-stats." + uuidString);
                        playerStats.put(uuid, found);
                        loaded++;
                    } catch (IllegalArgumentException e) {
                        plugin.getLogger().warning("Invalid UUID in player-stats: " + uuidString);
                    }
                }

                plugin.getLogger().info("Loaded stats for " + loaded + " players");
            }
        }
    }

    /**
     * Salva i dati nel file data.yml.
     * Include blocchi regalo e statistiche giocatori.
     */
    public void saveData() {
        dataConfig = new YamlConfiguration();

        // Save gift blocks
        int index = 0;
        for (Map.Entry<Location, GiftBlock> entry : giftBlocks.entrySet()) {
            Location loc = entry.getKey();
            GiftBlock block = entry.getValue();

            // Skip blocks with null world (shouldn't happen but safety check)
            if (loc.getWorld() == null) {
                plugin.getLogger().warning("Skipping gift block with null world at save");
                continue;
            }

            String path = "gift-blocks." + index;

            dataConfig.set(path + ".world", loc.getWorld().getName());
            dataConfig.set(path + ".x", loc.getX());
            dataConfig.set(path + ".y", loc.getY());
            dataConfig.set(path + ".z", loc.getZ());
            dataConfig.set(path + ".claimed", block.isClaimed());
            dataConfig.set(path + ".claimed-by", block.getClaimedBy() != null ? block.getClaimedBy().toString() : null);

            index++;
        }

        // Save player stats
        for (Map.Entry<UUID, Integer> entry : playerStats.entrySet()) {
            dataConfig.set("player-stats." + entry.getKey().toString(), entry.getValue());
        }

        try {
            dataConfig.save(dataFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save data.yml!");
            e.printStackTrace();
        }
    }

    /**
     * Aggiunge un nuovo blocco regalo.
     * 
     * @param location Posizione del blocco regalo
     */
    public void addGiftBlock(Location location) {
        giftBlocks.put(location, new GiftBlock(location, false, null));
        saveData();
    }

    /**
     * Rimuove un blocco regalo.
     * 
     * @param location Posizione del blocco da rimuovere
     */
    public void removeGiftBlock(Location location) {
        giftBlocks.remove(location);
        saveData();
    }

    /**
     * Rimuove tutti i blocchi regalo.
     */
    public void removeAllGiftBlocks() {
        giftBlocks.clear();
        saveData();
    }

    /**
     * Verifica se una location contiene un blocco regalo.
     * 
     * @param location Posizione da verificare
     * @return true se è un blocco regalo, false altrimenti
     */
    public boolean isGiftBlock(Location location) {
        return giftBlocks.containsKey(location);
    }

    /**
     * Ottiene il blocco regalo a una specifica location.
     * 
     * @param location Posizione del blocco
     * @return Il GiftBlock o null se non esiste
     */
    public GiftBlock getGiftBlock(Location location) {
        return giftBlocks.get(location);
    }

    /**
     * Ottiene una copia della mappa di tutti i blocchi regalo.
     * 
     * @return Mappa immutabile di blocchi regalo
     */
    public Map<Location, GiftBlock> getGiftBlocks() {
        return new HashMap<>(giftBlocks);
    }

    /**
     * Reclama un blocco regalo per un giocatore.
     * Incrementa automaticamente le statistiche del giocatore.
     * 
     * @param location Posizione del blocco da reclamare
     * @param player   UUID del giocatore
     */
    public void claimGiftBlock(Location location, UUID player) {
        GiftBlock block = giftBlocks.get(location);
        if (block != null && !block.isClaimed()) {
            block.setClaimed(true);
            block.setClaimedBy(player);

            // Increment player stats
            playerStats.put(player, playerStats.getOrDefault(player, 0) + 1);

            saveData();
        }
    }

    /**
     * Ottiene le statistiche di un giocatore.
     * 
     * @param player UUID del giocatore
     * @return Numero di regali trovati
     */
    public int getPlayerStats(UUID player) {
        return playerStats.getOrDefault(player, 0);
    }

    /**
     * Ottiene una copia della mappa delle statistiche.
     * 
     * @return Mappa immutabile delle statistiche
     */
    public Map<UUID, Integer> getPlayerStats() {
        return new HashMap<>(playerStats);
    }

    /**
     * Ottiene la classifica ordinata per regali trovati.
     * 
     * @return Lista ordinata di entry UUID-Statistiche
     */
    public List<Map.Entry<UUID, Integer>> getLeaderboard() {
        List<Map.Entry<UUID, Integer>> leaderboard = new ArrayList<>(playerStats.entrySet());
        leaderboard.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        return leaderboard;
    }

    /**
     * Ottiene il rank di un giocatore nella classifica.
     * 
     * @param player UUID del giocatore
     * @return Posizione in classifica (1-based) o -1 se non in classifica
     */
    public int getPlayerRank(UUID player) {
        List<Map.Entry<UUID, Integer>> leaderboard = getLeaderboard();
        for (int i = 0; i < leaderboard.size(); i++) {
            if (leaderboard.get(i).getKey().equals(player)) {
                return i + 1;
            }
        }
        return -1;
    }

    /**
     * Resetta le statistiche di un singolo giocatore.
     * 
     * @param player UUID del giocatore
     */
    public void resetPlayerStats(UUID player) {
        playerStats.remove(player);
        saveData();
    }

    /**
     * Resetta le statistiche di tutti i giocatori.
     */
    public void resetAllPlayerStats() {
        playerStats.clear();
        saveData();
    }

    /**
     * Ottiene il numero totale di blocchi regalo.
     * 
     * @return Numero totale di regali
     */
    public int getTotalGifts() {
        return giftBlocks.size();
    }

    /**
     * Ottiene il numero di regali già reclamati.
     * 
     * @return Numero di regali trovati
     */
    public int getClaimedGifts() {
        return (int) giftBlocks.values().stream()
                .filter(GiftBlock::isClaimed)
                .count();
    }

    /**
     * Ottiene il numero di regali ancora da trovare.
     * 
     * @return Numero di regali non reclamati
     */
    public int getUnclaimedGifts() {
        return getTotalGifts() - getClaimedGifts();
    }
}
