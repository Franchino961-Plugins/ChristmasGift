# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [1.4.0] - 2026-02-01

### Fixed
- NPE when a gift block exists in a non-existent world
- NPE on null `ConfigurationSection`
- Crash caused by invalid UUIDs in `data.yml`

### Improved
- Full JavaDoc added to all main classes
- Enhanced error handling with try-catch in `onEnable()`
- Detailed logging with counters (loaded/skipped)
- Automatic data validation on load
- Removed unused Jitpack repository from `pom.xml`
- Improved log messages for troubleshooting

## [1.3.0]

### Added
- Support for custom Base64 textures
- Improved message system
- Italian/English translations

## [1.2.0]

### Added
- PlaceholderAPI integration
- Leaderboard system
- Advanced admin commands

## [1.1.0]

### Added
- First public release
- Base gift block system
- Core commands and permissions

## [Unreleased]

### Planned
- Additional language support
- GUI for gift configuration
- Per-world settings

---

## Version History

### How to Read Version Numbers
- **Major.Minor.Patch** (e.g., 1.4.0)
  - **Major**: Breaking changes or major feature additions
  - **Minor**: New features, backward compatible
  - **Patch**: Bug fixes and small improvements

[1.4.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.4.0
[1.3.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.3.0
[1.2.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.2.0
[1.1.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.1.0
