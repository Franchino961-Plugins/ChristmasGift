# Changelog

Tutte le modifiche rilevanti a questo progetto saranno documentate in questo file.

Il formato è basato su [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
e questo progetto segue il [Versionamento Semantico](https://semver.org/spec/v2.0.0.html).

## [1.4.0] - Febbraio 2026

### 🐛 Bug Fix Critici
- ✅ Risolto NPE quando un blocco regalo è in un world non esistente
- ✅ Risolto NPE su `ConfigurationSection` null
- ✅ Risolto crash su UUID invalidi in `data.yml`

### 📚 Miglioramenti Codice
- ✅ Aggiunto JavaDoc completo su tutte le classi principali
- ✅ Migliorata gestione errori con try-catch in `onEnable()`
- ✅ Logging dettagliato con contatori (loaded/skipped)
- ✅ Validazione automatica dati al caricamento

### 🔧 Ottimizzazioni
- ✅ Rimosso repository Jitpack non utilizzato da `pom.xml`
- ✅ Migliorati messaggi di log per troubleshooting

## [1.3.0]

### Aggiunto
- Supporto per texture Base64 custom
- Sistema di messaggi migliorato
- Traduzioni italiano/inglese

## [1.2.0]

### Aggiunto
- Integrazione PlaceholderAPI
- Sistema di classifica
- Comandi admin avanzati

## [1.1.0]

### Aggiunto
- Primo rilascio pubblico
- Sistema base di blocchi regalo
- Comandi e permessi fondamentali

## [Non Rilasciato]

### Pianificato
- Supporto per lingue aggiuntive
- GUI per la configurazione dei regali
- Impostazioni per mondo

---

## Cronologia Versioni

### Come Leggere i Numeri di Versione
- **Major.Minor.Patch** (es. 1.4.0)
  - **Major**: Modifiche incompatibili o aggiunta di funzionalità principali
  - **Minor**: Nuove funzionalità, compatibili con versioni precedenti
  - **Patch**: Correzioni di bug e piccoli miglioramenti

[1.4.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.4.0
[1.3.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.3.0
[1.2.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.2.0
[1.1.0]: https://github.com/franchino961/christmasgift/releases/tag/v1.1.0
