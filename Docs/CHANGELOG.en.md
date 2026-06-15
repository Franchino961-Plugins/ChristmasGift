# Changelog - ChristmasGift

All notable changes to the **ChristmasGift** plugin will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

---

## [1.4.0] - 2026-02-01

### Added
- **JavaDoc**: Full JavaDoc added to all main classes.

### Changed
- **Error Handling**: Enhanced error handling with try-catch in `onEnable()`.
- **Logging**: Detailed logging with counters (loaded/skipped).
- **Validation**: Automatic data validation on load.
- **Build**: Removed unused Jitpack repository from `pom.xml`.
- **Logging**: Improved log messages for troubleshooting.

### Fixed
- **NPE**: Fixed NPE when a gift block exists in a non-existent world.
- **NPE**: Fixed NPE on null `ConfigurationSection`.
- **Crash**: Fixed crash caused by invalid UUIDs in `data.yml`.

---

## [1.3.0] - 2026-01-15

### Added
- **Custom Textures**: Support for custom Base64 textures.
- **Message System**: Improved message system.
- **Localization**: Italian/English translations.

---

## [1.2.0] - 2026-01-05

### Added
- **PlaceholderAPI**: PlaceholderAPI integration.
- **Leaderboard**: Leaderboard system.
- **Admin Commands**: Advanced admin commands.

---

## [1.1.0] - 2026-01-01

### Added
- **Initial Release**: First public release.
- **Gift Block System**: Base gift block system.
- **Commands**: Core commands and permissions.

---

## Development Roadmap

### Phase 1 - Initial Release ✅
- Base gift block system.
- Core commands and permissions.

### Phase 2 - Integrations ✅
- PlaceholderAPI integration.
- Leaderboard system.

### Phase 3 - Advanced Features ✅
- Custom Base64 textures.
- Multilingual support.

### Phase 4 - Expansion 📋
- Additional language support.
- GUI for gift configuration.
- Per-world settings.

---

*Format: [Version] - Date*
*Categories: Added, Changed, Fixed, Removed*
