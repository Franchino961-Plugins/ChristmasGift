# 🎁 ChristmasGift

[![Version](https://img.shields.io/badge/version-1.4.0-blue.svg)]()
[![Minecraft](https://img.shields.io/badge/minecraft-1.20+-green.svg)](https://www.minecraft.net/)
[![License](https://img.shields.io/badge/license-MIT-yellow.svg)](LICENSE)

**ChristmasGift** è un plugin Minecraft per Spigot/Paper che permette di creare una caccia al tesoro natalizia con blocchi regalo nascosti nel mondo. I giocatori possono cercare e raccogliere i regali per competere nella classifica globale!

## 📋 Caratteristiche

- **🎁 Blocchi Regalo Personalizzabili**: Usa blocchi normali o teste con texture Base64 custom
- **🎨 Texture da minecraft-heads.com**: Aggiungi texture personalizzate senza plugin aggiuntivi
- **📊 Sistema di Classifica**: Traccia quali giocatori hanno trovato più regali
- **💾 Persistenza Dati**: Salvataggio automatico in `data.yml` con gestione errori robusta
- **🏆 Statistiche Giocatore**: Ogni player può vedere quanti regali ha trovato e il proprio rank
- **🔄 Sostituzione Blocchi**: Configura cosa succede dopo che un regalo viene raccolto
- **📝 Messaggi Personalizzabili**: Tutti i messaggi sono configurabili in `lang.yml`
- **🌍 Supporto Multi-Lingua**: Traduzioni in italiano e inglese incluse
- **🔌 PlaceholderAPI Integration**: Supporto per placeholder opzionale
- **⚙️ Comandi Completi**: Gestione admin con comandi intuitivi
- **🎯 Tab Completion**: Autocompletamento comandi per facilità d'uso
- **🛡️ Gestione Errori Robusta**: Nessun crash per world mancanti o dati corrotti (v1.4.0)
- **📚 Codice Documentato**: JavaDoc completo per sviluppatori (v1.4.0)

## 🚀 Installazione

1. Scarica il file `.jar` del plugin
2. Inserisci il file `.jar` nella cartella `plugins` del tuo server
3. **(Opzionale)** Installa PlaceholderAPI per i placeholder
4. Riavvia o ricarica il tuo server
5. I file di configurazione verranno generati automaticamente in `plugins/ChristmasGift/`
6. Configura `config.yml` e `lang.yml` secondo le tue preferenze
7. Imposta una texture personalizzata (vedi sotto)
8. Usa `/cg give` per ottenere blocchi regalo

## 📖 Utilizzo

### Comandi

| Comando | Descrizione | Permesso | Alias |
|---------|-------------|----------|-------|
| `/cg give` | Ottieni un blocco regalo | `christmasgift.admin` | `/gift give`, `/christmasgift give` |
| `/cg stats` | Mostra le tue statistiche | `christmasgift.use` | `/gift stats`, `/christmasgift stats` |
| `/cg leaderboard` | Mostra la classifica globale (top 10) | `christmasgift.admin` | `/cg lb`, `/gift lb` |
| `/cg remove <x> <y> <z>` | Rimuovi un blocco regalo specifico | `christmasgift.admin` | `/gift remove` |
| `/cg removeall` | Rimuovi tutti i blocchi regalo | `christmasgift.admin` | `/gift removeall` |
| `/cg reset <player>` | Reset statistiche di un giocatore | `christmasgift.admin` | `/gift reset` |
| `/cg resetall` | Reset di tutte le statistiche | `christmasgift.admin` | `/gift resetall` |
| `/cg reload` | Ricarica la configurazione | `christmasgift.admin` | `/gift reload` |

**Alias principali:** `/cg`, `/gift`, `/christmasgift`

### Permessi

| Permesso | Descrizione | Default |
|----------|-------------|---------|
| `christmasgift.use` | Permette di usare i comandi base | Tutti |
| `christmasgift.claim` | Permette di raccogliere i blocchi regalo | Tutti |
| `christmasgift.admin` | Permette di usare i comandi admin | OP |

### Come Usare

1. **Ottenere Blocchi Regalo**: Usa `/cg give` (richiede permesso admin)
2. **Piazzare i Regali**: Piazza i blocchi regalo nel mondo come decorazioni nascoste
3. **Raccogliere Regali**: I giocatori cliccano destro sui blocchi per raccoglierli
4. **Vedere Statistiche**: Usa `/cg stats` per vedere quanti regali hai trovato
5. **Classifica**: Gli admin possono vedere la top 10 con `/cg leaderboard`

## 🎨 Texture Personalizzate

### Come Usare Texture Custom da minecraft-heads.com

Il plugin supporta **texture Base64** per le teste dei blocchi regalo senza bisogno di plugin esterni!

### Passaggi per Aggiungere Texture:

1. **Trova una testa su minecraft-heads.com:**
   - Vai su https://minecraft-heads.com/
   - Cerca la categoria che ti interessa (es. "Christmas", "Gifts")
   - Clicca sulla testa che vuoi

2. **Copia il Value:**
   - Clicca su "Value" (non Minecraft URL!)
   - Copia la stringa Base64 (esempio: `eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6...`)

3. **Incolla nel config.yml:**
   ```yaml
   gift-block:
     type: PLAYER_HEAD
     display-name: "&c&lChristmas Gift"
     head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
   ```

4. **Riavvia o usa `/cg reload`**

✨ **Funziona immediatamente senza plugin aggiuntivi!**

### Texture Consigliate

Alcune texture natalizie popolari da minecraft-heads.com:
- 🎁 **Regalo Rosso**: Cerca "Red Present"
- 🎄 **Albero di Natale**: Cerca "Christmas Tree"
- ⛄ **Pupazzo di Neve**: Cerca "Snowman"
- 🔔 **Campana**: Cerca "Bell"
- 🎅 **Babbo Natale**: Cerca "Santa"

## ⚙️ Configurazione

### config.yml

```yaml
# Configurazione Blocco Regalo
gift-block:
  # Tipo di blocco (PLAYER_HEAD per teste custom, o qualsiasi Material valido)
  type: PLAYER_HEAD
  
  # Nome visualizzato del blocco regalo
  display-name: "&c&l🎁 &a&lRegalo di Natale &c&l🎁"
  
  # Texture Base64 da minecraft-heads.com (solo per PLAYER_HEAD)
  # Esempio: Regalo rosso con fiocco
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
  
  # Sostituisci il blocco dopo che viene raccolto
  replace-after-claim: true
  
  # Blocco sostitutivo (AIR per rimuoverlo completamente)
  replacement-block:
    type: AIR

# Lingua (en_us o it_it)
language: it_it
```

### lang.yml

Tutti i messaggi del plugin sono completamente personalizzabili. Esempio:

```yaml
# Messaggi in Italiano
it_it:
  prefix: "&8[&c&lChristmasGift&8] &r"
  
  # Messaggi Regalo
  gift-claimed: "&aHai trovato un regalo! &7(&e{found}&7 totali)"
  already-claimed: "&cQuesto regalo è già stato raccolto!"
  gift-placed: "&aRegalo piazzato con successo!"
  gift-removed: "&cRegalo rimosso!"
  
  # Statistiche
  stats-header: "&6&l=== Le Tue Statistiche ==="
  stats-found: "&eRegali trovati: &a{found}"
  stats-rank: "&eClassifica: &a#{rank}"
  
  # Classifica
  leaderboard-header: "&6&l=== Top 10 Giocatori ==="
  leaderboard-entry: "&e#{position} &7- &f{player} &7(&a{found} regali&7)"
  leaderboard-empty: "&cNessun giocatore ha ancora trovato regali!"
  
  # Errori
  no-permission: "&cNon hai il permesso per fare questo!"
  player-only: "&cQuesto comando può essere usato solo da un giocatore!"
  player-not-found: "&cGiocatore {player} non trovato!"
  gift-not-found: "&cNessun regalo trovato a queste coordinate!"
  invalid-coordinates: "&cCoordinate non valide!"
  
  # Admin
  all-gifts-removed: "&aRimossi {count} blocchi regalo!"
  player-reset: "&aStatistiche di {player} resettate! &7({count} regali)"
  all-stats-reset: "&aStatistiche di {count} giocatori resettate!"
  config-reloaded: "&aConfigurazione ricaricata con successo!"
  remove-usage: "&cUso: /cg remove <x> <y> <z>"
  reset-usage: "&cUso: /cg reset <player>"
  unknown-command: "&cComando sconosciuto! Usa /cg per vedere i comandi disponibili."

# English Messages
en_us:
  prefix: "&8[&c&lChristmasGift&8] &r"
  gift-claimed: "&aYou found a gift! &7(&e{found}&7 total)"
  already-claimed: "&cThis gift has already been claimed!"
  # ... (stessa struttura dell'italiano)
```

## 🔌 PlaceholderAPI

Se hai PlaceholderAPI installato, puoi usare questi placeholder:

| Placeholder | Descrizione | Esempio Output |
|-------------|-------------|----------------|
| `%christmasgift_found%` | Numero di regali trovati dal giocatore | `5` |
| `%christmasgift_rank%` | Posizione in classifica | `3` |
| `%christmasgift_total_gifts%` | Numero totale di regali nel mondo | `20` |
| `%christmasgift_claimed_gifts%` | Numero di regali già raccolti | `12` |
| `%christmasgift_unclaimed_gifts%` | Numero di regali ancora da trovare | `8` |
| `%christmasgift_top_<position>_name%` | Nome del giocatore in posizione X | `Notch` |
| `%christmasgift_top_<position>_found%` | Regali trovati dal giocatore in posizione X | `15` |

**Esempio di utilizzo in scoreboard:**
```yaml
# In DeluxeMenus, ScoreboardAPI, etc.
lines:
  - "&6&lChristmas Event"
  - "&eRegali trovati: &a%christmasgift_found%"
  - "&eClassifica: &a#%christmasgift_rank%"
  - ""
  - "&6&lTop 3:"
  - "&e1. &f%christmasgift_top_1_name% &7(%christmasgift_top_1_found%)"
  - "&e2. &f%christmasgift_top_2_name% &7(%christmasgift_top_2_found%)"
  - "&e3. &f%christmasgift_top_3_name% &7(%christmasgift_top_3_found%)"
```

## 📊 Gestione Dati

### data.yml

Il plugin salva automaticamente tutti i dati in `plugins/ChristmasGift/data.yml`:

```yaml
# Blocchi Regalo Piazzati
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

# Statistiche Giocatori
player-stats:
  "069a79f4-44e9-4726-a5be-fca90e38aaf5": 5
  "f84c6a79-0a4e-45e7-879b-cd49ebd4c4e2": 3
```

### Backup e Sicurezza (v1.4.0)

Il plugin ora include gestione errori robusta:
- ✅ **Nessun crash** se un world viene eliminato o rinominato
- ✅ **Validazione automatica** dei dati al caricamento
- ✅ **Logging dettagliato** per troubleshooting
- ✅ **Skip automatico** di blocchi regalo in world non esistenti

**Esempio log al caricamento:**
```
[ChristmasGift] Created new data.yml file
[ChristmasGift] Loaded 15 gift blocks (skipped 2 invalid)
[ChristmasGift] Loaded stats for 8 players
[ChristmasGift] PlaceholderAPI hooked successfully!
[ChristmasGift] ChristmasGift v1.4.0 enabled successfully!
```

## 🎯 Esempi di Utilizzo

### Scenario 1: Evento Natalizio

1. **Setup Iniziale:**
   ```
   /cg give Admin 50
   ```
   
2. **Nascondi i Regali:**
   - Piazza 50 blocchi regalo in giro per il mondo
   - Nascondili in luoghi creativi (alberi, case, grotte, ecc.)

3. **Annuncia l'Evento:**
   ```
   /broadcast §6§l🎄 EVENTO NATALIZIO! 🎄
   /broadcast §eTrova i 50 regali nascosti nel mondo!
   /broadcast §eUsa /cg stats per vedere i tuoi progressi!
   ```

4. **Monitora i Progressi:**
   ```
   /cg leaderboard  # Vedi chi sta vincendo
   ```

5. **Premia i Vincitori:**
   - Controlla la classifica finale
   - Premia i top 3 giocatori

### Scenario 2: Caccia al Tesoro Quotidiana

1. **Nascondi 5 Regali al Giorno:**
   ```
   /cg give Admin 5
   ```

2. **Resetta le Statistiche Ogni Settimana:**
   ```
   /cg resetall
   ```

3. **Usa Placeholder in Scoreboard:**
   - Mostra i progressi in tempo reale
   - Crea competizione tra giocatori

## 🔧 Risoluzione Problemi

### Il blocco regalo non funziona

**Problema:** Cliccando destro sul blocco non succede nulla

**Soluzioni:**
1. Verifica di avere il permesso `christmasgift.claim`
2. Controlla che il blocco sia effettivamente un regalo (usa `/cg list` se admin)
3. Verifica che non sia già stato raccolto

### La texture non si carica

**Problema:** La testa appare come testa di Steve

**Soluzioni:**
1. Verifica di aver copiato il **Value** (non l'URL) da minecraft-heads.com
2. Controlla che la stringa Base64 sia completa (nessun carattere mancante)
3. Assicurati che `type: PLAYER_HEAD` sia impostato
4. Usa `/cg reload` dopo aver modificato il config

### Errore "World non trovato"

**Problema (v1.3.0 e precedenti):** Plugin crashava se un world veniva eliminato

**Soluzione (v1.4.0+):** 
- ✅ Problema risolto! Il plugin ora skippa automaticamente blocchi in world non esistenti
- Controlla i log per vedere quali blocchi sono stati skippati
- Rimuovi manualmente le entry da `data.yml` se necessario

### Statistiche non salvate

**Problema:** Le statistiche si resettano al riavvio

**Soluzioni:**
1. Verifica che `data.yml` esista in `plugins/ChristmasGift/`
2. Controlla i permessi del file (deve essere scrivibile)
3. Controlla i log per errori di salvataggio
4. Usa `/cg reload` per forzare un salvataggio

## 📈 Changelog

### v1.4.0 (Febbraio 2026)
**🛡️ Bug Fixes Critici:**
- ✅ Risolto NPE quando un blocco regalo è in un world non esistente
- ✅ Risolto NPE su ConfigurationSection null
- ✅ Risolto crash su UUID invalidi in data.yml

**📚 Miglioramenti Codice:**
- ✅ Aggiunto JavaDoc completo su tutte le classi principali
- ✅ Migliorata gestione errori con try-catch in onEnable()
- ✅ Logging dettagliato con contatori (loaded/skipped)
- ✅ Validazione automatica dati al caricamento

**🔧 Ottimizzazioni:**
- ✅ Rimosso repository Jitpack non utilizzato da pom.xml
- ✅ Migliorati messaggi di log per troubleshooting

### v1.3.0
- Aggiunto supporto per texture Base64 custom
- Migliorato sistema di messaggi
- Aggiunte traduzioni italiano/inglese

### v1.2.0
- Aggiunta integrazione PlaceholderAPI
- Implementato sistema di classifica
- Aggiunti comandi admin avanzati

### v1.1.0
- Primo rilascio pubblico
- Sistema base di blocchi regalo
- Comandi e permessi fondamentali

## 🤝 Supporto

Per bug report, richieste di funzionalità o domande:
- Apri una issue su GitHub
- Contatta lo sviluppatore

## 📜 Licenza

Questo plugin è rilasciato sotto licenza MIT. Vedi il file LICENSE per i dettagli.

## 👨‍💻 Sviluppatore

Sviluppato da **Franchino961**

---

**Buon divertimento con la tua caccia al tesoro natalizia! 🎁🎄**
