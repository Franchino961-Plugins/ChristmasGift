package com.franchino961.christmasgift.config;

import com.franchino961.christmasgift.ChristmasGift;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class MessagesManager {

    private final ChristmasGift plugin;
    private File langFile;
    private FileConfiguration langConfig;
    private String language;

    public MessagesManager(ChristmasGift plugin) {
        this.plugin = plugin;
    }

    public void loadMessages() {
        langFile = new File(plugin.getDataFolder(), "lang.yml");
        
        if (!langFile.exists()) {
            plugin.saveResource("lang.yml", false);
        }
        
        langConfig = YamlConfiguration.loadConfiguration(langFile);
        language = plugin.getConfig().getString("language", "en_us");
        
        // Validate language exists in lang.yml
        if (!langConfig.contains(language)) {
            plugin.getLogger().warning("Language '" + language + "' not found in lang.yml! Defaulting to en_us");
            language = "en_us";
        }
    }

    public void reloadMessages() {
        langConfig = YamlConfiguration.loadConfiguration(langFile);
        language = plugin.getConfig().getString("language", "en_us");
        
        // Validate language exists in lang.yml
        if (!langConfig.contains(language)) {
            plugin.getLogger().warning("Language '" + language + "' not found in lang.yml! Defaulting to en_us");
            language = "en_us";
        }
    }

    public void saveMessages() {
        try {
            langConfig.save(langFile);
        } catch (IOException e) {
            plugin.getLogger().severe("Could not save lang.yml!");
            e.printStackTrace();
        }
    }

    public String getMessage(String path) {
        String fullPath = language + "." + path;
        String message = langConfig.getString(fullPath, "Message not found: " + path);
        return formatColor(message);
    }

    public String getMessage(String path, String... replacements) {
        String message = getMessage(path);
        
        for (int i = 0; i < replacements.length - 1; i += 2) {
            message = message.replace(replacements[i], replacements[i + 1]);
        }
        
        return message;
    }

    private String formatColor(String text) {
        return text.replace("&", "§");
    }

    public FileConfiguration getLangConfig() {
        return langConfig;
    }
    
    public String getLanguage() {
        return language;
    }
}
