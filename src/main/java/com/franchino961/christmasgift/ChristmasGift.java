package com.franchino961.christmasgift;

import com.franchino961.christmasgift.commands.ChristmasGiftCommand;
import com.franchino961.christmasgift.config.ConfigManager;
import com.franchino961.christmasgift.config.MessagesManager;
import com.franchino961.christmasgift.data.DataManager;
import com.franchino961.christmasgift.listeners.BlockInteractListener;
// import com.franchino961.christmasgift.listeners.HeadDatabaseListener;
import com.franchino961.christmasgift.placeholders.ChristmasGiftExpansion;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * ChristmasGift - Plugin per caccia al tesoro natalizia.
 * Permette di creare blocchi regalo nascosti che i giocatori possono trovare e
 * raccogliere.
 * 
 * @author Franchino961
 * @version 1.4.0
 * @since 1.0.0
 */
public class ChristmasGift extends JavaPlugin {

    private static ChristmasGift instance;
    private ConfigManager configManager;
    private MessagesManager messagesManager;
    private DataManager dataManager;

    /**
     * Chiamato quando il plugin viene abilitato.
     * Inizializza tutti i manager, comandi, listener e integrazioni.
     */
    @Override
    public void onEnable() {
        instance = this;

        try {
            // Initialize managers
            configManager = new ConfigManager(this);
            messagesManager = new MessagesManager(this);
            dataManager = new DataManager(this);

            // Load configurations
            configManager.loadConfig();
            messagesManager.loadMessages();
            dataManager.loadData();

            // Register commands
            ChristmasGiftCommand commandExecutor = new ChristmasGiftCommand(this);
            getCommand("christmasgift").setExecutor(commandExecutor);
            getCommand("christmasgift").setTabCompleter(commandExecutor);

            // Register listeners
            getServer().getPluginManager().registerEvents(new BlockInteractListener(this), this);

            // Register PlaceholderAPI expansion if available
            if (getServer().getPluginManager().getPlugin("PlaceholderAPI") != null) {
                new ChristmasGiftExpansion(this).register();
                getLogger().info("PlaceholderAPI hooked successfully!");
            }

            getLogger().info("ChristmasGift v" + getDescription().getVersion() + " enabled successfully!");

        } catch (Exception e) {
            getLogger().severe("Failed to enable ChristmasGift: " + e.getMessage());
            e.printStackTrace();
            getServer().getPluginManager().disablePlugin(this);
        }
    }

    /**
     * Chiamato quando il plugin viene disabilitato.
     * Salva tutti i dati prima della chiusura.
     */
    @Override
    public void onDisable() {
        // Save data before disabling
        if (dataManager != null) {
            dataManager.saveData();
            getLogger().info("Data saved successfully");
        }
        getLogger().info("ChristmasGift v" + getDescription().getVersion() + " disabled!");
    }

    /**
     * Ottiene l'istanza singleton del plugin.
     * 
     * @return L'istanza di ChristmasGift
     */
    public static ChristmasGift getInstance() {
        return instance;
    }

    /**
     * Ottiene il ConfigManager.
     * 
     * @return Il gestore della configurazione
     */
    public ConfigManager getConfigManager() {
        return configManager;
    }

    /**
     * Ottiene il MessagesManager.
     * 
     * @return Il gestore dei messaggi
     */
    public MessagesManager getMessagesManager() {
        return messagesManager;
    }

    /**
     * Ottiene il DataManager.
     * 
     * @return Il gestore dei dati
     */
    public DataManager getDataManager() {
        return dataManager;
    }
}
