# Changelog - ChristmasGift

Tutte le modifiche rilevanti al plugin **ChristmasGift** saranno documentate in questo file.

Il formato è basato su [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
e questo progetto segue il [Versionamento Semantico](https://semver.org/spec/v2.0.0.html).

---

## [1.4.0] - 2026-02-01

### Aggiunto
- **JavaDoc**: Aggiunto JavaDoc completo su tutte le classi principali.

### Modificato
- **Gestione Errori**: Migliorata la gestione degli errori con try-catch in `onEnable()`.
- **Logging**: Logging dettagliato con contatori (loaded/skipped).
- **Validazione**: Validazione automatica dei dati al caricamento.
- **Build**: Rimosso repository Jitpack non utilizzato da `pom.xml`.
- **Logging**: Migliorati i messaggi di log per il troubleshooting.

### Risolto
- **NPE**: Risolto NPE quando un blocco regalo si trova in un world non esistente.
- **NPE**: Risolto NPE su `ConfigurationSection` null.
- **Crash**: Risolto crash causato da UUID non validi in `data.yml`.

---

## [1.3.0] - 2026-01-15

### Aggiunto
- **Texture Personalizzate**: Supporto per texture Base64 custom.
- **Sistema Messaggi**: Sistema di messaggi migliorato.
- **Localizzazione**: Traduzioni italiano/inglese.

---

## [1.2.0] - 2026-01-05

### Aggiunto
- **PlaceholderAPI**: Integrazione PlaceholderAPI.
- **Classifica**: Sistema di classifica.
- **Comandi Admin**: Comandi admin avanzati.

---

## [1.1.0] - 2026-01-01

### Aggiunto
- **Prima Release**: Primo rilascio pubblico.
- **Sistema Regalo**: Sistema base di blocchi regalo.
- **Comandi**: Comandi e permessi fondamentali.

---

## Roadmap di Sviluppo

### Fase 1 - Prima Release ✅
- Sistema base di blocchi regalo.
- Comandi e permessi fondamentali.

### Fase 2 - Integrazioni ✅
- Integrazione PlaceholderAPI.
- Sistema di classifica.

### Fase 3 - Funzionalità Avanzate ✅
- Texture Base64 personalizzate.
- Supporto multilingua.

### Fase 4 - Espansione 📋
- Supporto per lingue aggiuntive.
- GUI per la configurazione dei regali.
- Impostazioni per mondo.

---

*Formato: [Versione] - Data*
*Categorie: Aggiunto, Modificato, Risolto, Rimosso*
