# 🎁 ChristmasGift

[![Version](https://img.shields.io/badge/version-1.4.0-blue.svg)]()
[![Minecraft](https://img.shields.io/badge/minecraft-1.20+-green.svg)](https://www.minecraft.net/)
[![License](https://img.shields.io/badge/license-MIT-yellow.svg)](LICENSE)
[![Spigot](https://img.shields.io/badge/Spigot-1.20+-orange.svg)](https://www.spigotmc.org/)

[![en](https://img.shields.io/badge/lang-en-red.svg)](README.md)
[![it](https://img.shields.io/badge/lang-it-green.svg)](MD/README.it.md)

> 📝 [Changelog](MD/CHANGELOG.en.md)

**ChristmasGift** is a Minecraft plugin for Spigot/Paper that allows you to create a Christmas treasure hunt with hidden gift blocks in the world. Players can search for and collect gifts to compete on the global leaderboard!

## 📋 Features

- **🎁 Customisable Gift Blocks**: Use normal blocks or player heads with custom Base64 textures
- **🎨 Textures from minecraft-heads.com**: Add custom textures without additional plugins
- **📊 Leaderboard System**: Track which players have found the most gifts
- **💾 Data Persistence**: Automatic saving to `data.yml` with robust error handling
- **🏆 Player Statistics**: Each player can see how many gifts they've found and their rank
- **🔄 Block Replacement**: Configure what happens after a gift is collected
- **📝 Customisable Messages**: All messages are configurable in `lang.yml`
- **🌍 Multi-Language Support**: Italian and English translations included
- **🔌 PlaceholderAPI Integration**: Optional placeholder support
- **⚙️ Complete Commands**: Admin management with intuitive commands
- **🎯 Tab Completion**: Command auto-completion for ease of use
- **🛡️ Robust Error Handling**: No crashes for missing worlds or corrupted data (v1.4.0)
- **📚 Documented Code**: Full JavaDoc for developers (v1.4.0)

## 📦 Requirements

- **Server**: Spigot/Paper 1.20+
- **Java**: 17+
- **Optional dependencies**: PlaceholderAPI

## 🚀 Installation

1. Download the plugin `.jar` file
2. Place the `.jar` file in your server's `plugins` folder
3. **(Optional)** Install PlaceholderAPI for placeholders
4. Restart or reload your server
5. Configuration files will be automatically generated in `plugins/ChristmasGift/`
6. Configure `config.yml` and `lang.yml` according to your preferences
7. Set up a custom texture (see below)
8. Use `/cg give` to get gift blocks

## 📖 Usage

### Commands

| Command | Description | Permission | Alias |
|---------|-------------|------------|-------|
| `/cg give` | Get a gift block | `christmasgift.admin` | `/gift give`, `/christmasgift give` |
| `/cg stats` | Show your statistics | `christmasgift.use` | `/gift stats`, `/christmasgift stats` |
| `/cg leaderboard` | Show the global leaderboard (top 10) | `christmasgift.admin` | `/cg lb`, `/gift lb` |
| `/cg remove <x> <y> <z>` | Remove a specific gift block | `christmasgift.admin` | `/gift remove` |
| `/cg removeall` | Remove all gift blocks | `christmasgift.admin` | `/gift removeall` |
| `/cg reset <player>` | Reset a player's statistics | `christmasgift.admin` | `/gift reset` |
| `/cg resetall` | Reset all statistics | `christmasgift.admin` | `/gift resetall` |
| `/cg reload` | Reload configuration | `christmasgift.admin` | `/gift reload` |

**Main aliases:** `/cg`, `/gift`, `/christmasgift`

### Permissions

| Permission | Description | Default |
|------------|-------------|---------|
| `christmasgift.use` | Allows using basic commands | Everyone |
| `christmasgift.claim` | Allows collecting gift blocks | Everyone |
| `christmasgift.admin` | Allows using admin commands | OP |

### How to Use

1. **Get Gift Blocks**: Use `/cg give` (requires admin permission)
2. **Place Gifts**: Place gift blocks in the world as hidden decorations
3. **Collect Gifts**: Players right-click blocks to collect them
4. **View Statistics**: Use `/cg stats` to see how many gifts you've found
5. **Leaderboard**: Admins can view the top 10 with `/cg leaderboard`

## 🎨 Custom Textures

### How to Use Custom Textures from minecraft-heads.com

The plugin supports **Base64 textures** for gift block heads without needing external plugins!

### Steps to Add Textures:

1. **Find a head on minecraft-heads.com:**
   - Go to https://minecraft-heads.com/
   - Search for the category you want (e.g. "Christmas", "Gifts")
   - Click on the head you want

2. **Copy the Value:**
   - Click on "Value" (not Minecraft URL!)
   - Copy the Base64 string (example: `eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6...`)

3. **Paste into config.yml:**
   ```yaml
   gift-block:
     type: PLAYER_HEAD
     display-name: "&c&lChristmas Gift"
     head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
   ```

4. **Restart or use `/cg reload`**

✨ **Works immediately without additional plugins!**

### Recommended Textures

Some popular Christmas textures from minecraft-heads.com:
- 🎁 **Red Present**: Search "Red Present"
- 🎄 **Christmas Tree**: Search "Christmas Tree"
- ⛄ **Snowman**: Search "Snowman"
- 🔔 **Bell**: Search "Bell"
- 🎅 **Santa**: Search "Santa"

## ⚙️ Configuration

### config.yml

```yaml
# Gift Block Configuration
gift-block:
  # Block type (PLAYER_HEAD for custom heads, or any valid Material)
  type: PLAYER_HEAD
  
  # Display name of gift block
  display-name: "&c&l🎁 &a&lChristmas Gift &c&l🎁"
  
  # Base64 texture from minecraft-heads.com (only for PLAYER_HEAD)
  # Example: Red present with bow
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
  
  # Replace block after it's claimed
  replace-after-claim: true
  
  # Replacement block (AIR to remove completely)
  replacement-block:
    type: AIR

# Language (en_us or it_it)
language: en_us
```

### lang.yml

All plugin messages are fully customisable. Example:

```yaml
# English Messages
en_us:
  prefix: "&8[&c&lChristmasGift&8] &r"
  
  # Gift Messages
  gift-claimed: "&aYou found a gift! &7(&e{found}&7 total)"
  already-claimed: "&cThis gift has already been claimed!"
  gift-placed: "&aGift placed successfully!"
  gift-removed: "&cGift removed!"
  
  # Statistics
  stats-header: "&6&l=== Your Statistics ==="
  stats-found: "&eGifts found: &a{found}"
  stats-rank: "&eRank: &a#{rank}"
  
  # Leaderboard
  leaderboard-header: "&6&l=== Top 10 Players ==="
  leaderboard-entry: "&e#{position} &7- &f{player} &7(&a{found} gifts&7)"
  leaderboard-empty: "&cNo players have found gifts yet!"
  
  # Errors
  no-permission: "&cYou don't have permission to do this!"
  player-only: "&cThis command can only be used by a player!"
  player-not-found: "&cPlayer {player} not found!"
  gift-not-found: "&cNo gift found at these coordinates!"
  invalid-coordinates: "&cInvalid coordinates!"
  
  # Admin
  all-gifts-removed: "&aRemoved {count} gift blocks!"
  player-reset: "&aReset {player}'s statistics! &7({count} gifts)"
  all-stats-reset: "&aReset statistics for {count} players!"
  config-reloaded: "&aConfiguration reloaded successfully!"
  remove-usage: "&cUsage: /cg remove <x> <y> <z>"
  reset-usage: "&cUsage: /cg reset <player>"
  unknown-command: "&cUnknown command! Use /cg to see available commands."

# Italian Messages
it_it:
  prefix: "&8[&c&lChristmasGift&8] &r"
  gift-claimed: "&aHai trovato un regalo! &7(&e{found}&7 totali)"
  already-claimed: "&cQuesto regalo è già stato raccolto!"
  # ... (same structure as English)
```

## 🔌 PlaceholderAPI

If you have PlaceholderAPI installed, you can use these placeholders:

| Placeholder | Description | Example Output |
|-------------|-------------|----------------|
| `%christmasgift_found%` | Number of gifts found by the player | `5` |
| `%christmasgift_rank%` | Leaderboard position | `3` |
| `%christmasgift_total_gifts%` | Total number of gifts in the world | `20` |
| `%christmasgift_claimed_gifts%` | Number of gifts already collected | `12` |
| `%christmasgift_unclaimed_gifts%` | Number of gifts still to find | `8` |
| `%christmasgift_top_<position>_name%` | Name of player at position X | `Notch` |
| `%christmasgift_top_<position>_found%` | Gifts found by player at position X | `15` |

**Example usage in scoreboard:**
```yaml
# In DeluxeMenus, ScoreboardAPI, etc.
lines:
  - "&6&lChristmas Event"
  - "&eGifts found: &a%christmasgift_found%"
  - "&eRank: &a#%christmasgift_rank%"
  - ""
  - "&6&lTop 3:"
  - "&e1. &f%christmasgift_top_1_name% &7(%christmasgift_top_1_found%)"
  - "&e2. &f%christmasgift_top_2_name% &7(%christmasgift_top_2_found%)"
  - "&e3. &f%christmasgift_top_3_name% &7(%christmasgift_top_3_found%)"
```

## 📊 Data Management

### data.yml

The plugin automatically saves all data in `plugins/ChristmasGift/data.yml`:

```yaml
# Placed Gift Blocks
gift-blocks:
  0:
    world: world
    x: 100.5
    y: 64.0
    z: -200.5
    claimed: false
    claimed-by: null
  1:
    world: world
    x: 150.5
    y: 70.0
    z: -180.5
    claimed: true
    claimed-by: "069a79f4-44e9-4726-a5be-fca90e38aaf5"

# Player Statistics
player-stats:
  "069a79f4-44e9-4726-a5be-fca90e38aaf5": 5
  "f84c6a79-0a4e-45e7-879b-cd49ebd4c4e2": 3
```

### Backup and Safety (v1.4.0)

The plugin now includes robust error handling:
- ✅ **No crashes** if a world is deleted or renamed
- ✅ **Automatic validation** of data on load
- ✅ **Detailed logging** for troubleshooting
- ✅ **Automatic skip** of gift blocks in non-existent worlds

**Example log on startup:**
```
[ChristmasGift] Created new data.yml file
[ChristmasGift] Loaded 15 gift blocks (skipped 2 invalid)
[ChristmasGift] Loaded stats for 8 players
[ChristmasGift] PlaceholderAPI hooked successfully!
[ChristmasGift] ChristmasGift v1.4.0 enabled successfully!
```

## 🎯 Usage Examples

### Scenario 1: Christmas Event

1. **Initial Setup:**
   ```
   /cg give Admin 50
   ```
   
2. **Hide the Gifts:**
   - Place 50 gift blocks around the world
   - Hide them in creative places (trees, houses, caves, etc.)

3. **Announce the Event:**
   ```
   /broadcast §6§l🎄 CHRISTMAS EVENT! 🎄
   /broadcast §eFind the 50 hidden gifts in the world!
   /broadcast §eUse /cg stats to see your progress!
   ```

4. **Monitor Progress:**
   ```
   /cg leaderboard  # See who's winning
   ```

5. **Reward the Winners:**
   - Check the final leaderboard
   - Reward the top 3 players

### Scenario 2: Daily Treasure Hunt

1. **Hide 5 Gifts Each Day:**
   ```
   /cg give Admin 5
   ```

2. **Reset Statistics Every Week:**
   ```
   /cg resetall
   ```

3. **Use Placeholders in Scoreboard:**
   - Show progress in real-time
   - Create competition between players

## 🔧 Troubleshooting

### Gift block doesn't work

**Problem:** Right-clicking the block does nothing

**Solutions:**
1. Verify you have the `christmasgift.claim` permission
2. Check that the block is actually a gift (use `/cg list` if admin)
3. Verify it hasn't already been collected

### Texture doesn't load

**Problem:** Head appears as Steve's head

**Solutions:**
1. Verify you copied the **Value** (not the URL) from minecraft-heads.com
2. Check that the Base64 string is complete (no missing characters)
3. Ensure `type: PLAYER_HEAD` is set
4. Use `/cg reload` after modifying config

### "World not found" error

**Problem (v1.3.0 and earlier):** Plugin crashed if a world was deleted

**Solution (v1.4.0+):** 
- ✅ Problem solved! Plugin now automatically skips blocks in non-existent worlds
- Check logs to see which blocks were skipped
- Manually remove entries from `data.yml` if needed

### Statistics not saved

**Problem:** Statistics reset on restart

**Solutions:**
1. Verify that `data.yml` exists in `plugins/ChristmasGift/`
2. Check file permissions (must be writable)
3. Check logs for save errors
4. Use `/cg reload` to force a save

## 📄 License

This project is released under the **MIT** license — see the [LICENSE](LICENSE) file for details.

## 👤 Author

**Franchino961** — [GitHub](https://github.com/Franchino961-Plugins)

## 🤝 Contributing

Contributions are welcome! Feel free to:
- 🐛 Report bugs in [issues](../../issues)
- 💡 Propose new features
- 🔧 Submit Pull Requests

## 💬 Support

For bug reports, feature requests, or questions:
- Open an [issue](../../issues) on GitHub
- Contact the developer

## 🔗 Useful Links

- 🎁 [SpigotMC](https://www.spigotmc.org/)
- 📚 [Spigot API Documentation](https://hub.spigotmc.org/javadocs/spigot/)
- 🔌 [PlaceholderAPI](https://www.spigotmc.org/resources/placeholderapi.6245/) — Optional dependency

## 📝 Changelog

See [CHANGELOG.en.md](MD/CHANGELOG.en.md) for complete version history.

---

**Enjoy your Christmas treasure hunt!**
