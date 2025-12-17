# 🎁 ChristmasGift

[![Version](https://img.shields.io/badge/version-1.3.0-blue.svg)]()
[![Minecraft](https://img.shields.io/badge/minecraft-1.20+-green.svg)](https://www.minecraft.net/)
[![License](https://img.shields.io/badge/license-MIT-yellow.svg)](LICENSE)

**ChristmasGift** è un plugin Minecraft per Spigot/Paper che permette di creare una caccia al tesoro natalizia con blocchi regalo nascosti nel mondo. I giocatori possono cercare e raccogliere i regali per competere nella classifica globale!

## 📋 Caratteristiche

- **🎁 Blocchi Regalo Personalizzabili**: Usa blocchi normali o teste con texture Base64 custom
- **🎨 Texture da minecraft-heads.com**: Aggiungi texture personalizzate senza plugin aggiuntivi
- **📊 Sistema di Classifica**: Traccia quali giocatori hanno trovato più regali
- **💾 Persistenza Dati**: Salvataggio automatico in `data.yml`
- **🏆 Statistiche Giocatore**: Ogni player può vedere quanti regali ha trovato
- **🔄 Sostituzione Blocchi**: Configura cosa succede dopo che un regalo viene raccolto
- **📝 Messaggi Personalizzabili**: Tutti i messaggi sono configurabili in `lang.yml`
- **🌍 Supporto Multi-Lingua**: Traduzioni in italiano e inglese incluse
- **🔌 PlaceholderAPI Integration**: Supporto per placeholder opzionale
- **⚙️ Comandi Completi**: Gestione admin con comandi intuitivi
- **🎯 Tab Completion**: Autocompletamento comandi per facilità d'uso

## 🚀 Installazione

1. **Scarica il file `.jar`** del plugin
2. **Inseriscilo nella cartella `plugins/`** del tuo server
3. **(Opzionale)** Installa PlaceholderAPI per i placeholder
4. **Avvia/riavvia il server**
5. **Configura** `config.yml` e `lang.yml` nella cartella `plugins/ChristmasGift/`
6. **Imposta una texture** personalizzata (vedi sotto)
7. Usa `/cg give` per ottenere blocchi regalo

## 🎨 Texture Personalizzate

### Come Usare Texture Custom da minecraft-heads.com

Il plugin supporta **texture Base64** per le teste dei blocchi regalo senza bisogno di plugin esterni!

### Passaggi per Aggiungere Texture:

1. **Trova una testa su minecraft-heads.com:**
   - Vai su https://minecraft-heads.com/
   - Cerca la categoria che ti interessa (es. "Christmas")
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

## 🎮 Comandi

| Comando | Descrizione | Permesso | Alias |
|---------|-------------|----------|-------|
| `/cg give` | Ottieni un blocco regalo | `christmasgift.admin` | `/gift give`, `/christmasgift give` |
| `/cg stats` | Mostra le tue statistiche | `christmasgift.use` | `/gift stats`, `/christmasgift stats` |
| `/cg leaderboard` | Mostra la classifica globale | `christmasgift.admin` | `/cg lb`, `/gift lb` |
| `/cg remove <x> <y> <z>` | Rimuovi un blocco regalo specifico | `christmasgift.admin` | `/gift remove` |
| `/cg removeall` | Rimuovi tutti i blocchi regalo | `christmasgift.admin` | `/gift removeall` |
| `/cg reset <player>` | Reset statistiche di un giocatore | `christmasgift.admin` | `/gift reset` |
| `/cg resetall` | Reset di tutte le statistiche | `christmasgift.admin` | `/gift resetall` |
| `/cg reload` | Ricarica la configurazione | `christmasgift.admin` | `/gift reload` |

**Alias principali:** `/cg`, `/gift`, `/christmasgift`

## 🔑 Permessi

| Permesso | Descrizione | Default |
|----------|-------------|---------|
| `christmasgift.use` | Permette di usare i comandi base | Tutti |
| `christmasgift.claim` | Permette di raccogliere i blocchi regalo | Tutti |
| `christmasgift.admin` | Permette di usare i comandi admin | OP |

## ⚙️ Configurazione

### config.yml

```yaml
gift-block:
  type: PLAYER_HEAD                    # PLAYER_HEAD o blocco normale
  display-name: "&c&l🎁 &a&lRegalo di Natale &c&l🎁"
  
  # Texture Base64 da minecraft-heads.com (solo per PLAYER_HEAD)
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
  
  replace-after-claim: true            # Sostituisci il blocco dopo il claim
  
  replacement-block:
    type: AIR                          # Blocco sostitutivo (AIR per rimuoverlo)
```

### lang.yml

Il plugin supporta più lingue. Attualmente incluse:
- 🇺🇸 Inglese (`en_us`)
- 🇮🇹 Italiano (`it_it`)

Puoi selezionare la lingua nel file `config.yml` con l'opzione `language: en_us` o `language: it_it`. Tutti i messaggi sono personalizzabili nel file `lang.yml`.

```yaml
en_us:
  prefix: "&c&l[ChristmasGift]&r "
  gift-claimed: "&a&lCongratulations! &aYou found a Christmas Gift! Total found: &e{found}"
  already-claimed: "&cThis gift has already been claimed by someone else!"
  no-permission: "&cYou don't have permission to do that!"
  # ...altri messaggi...

it_it:
  prefix: "&c&l[ChristmasGift]&r "
  gift-claimed: "&a&lComplimenti! &aHai trovato un Regalo di Natale! Totale trovati: &e{found}"
  already-claimed: "&cQuesto regalo è già stato raccolto da qualcun altro!"
  no-permission: "&cNon hai il permesso per fare questo!"
  # ...altri messaggi...
```

## 🔌 PlaceholderAPI (Opzionale)

Se hai PlaceholderAPI installato, sono disponibili questi placeholder:

| Placeholder | Descrizione |
|-------------|-------------|
| `%christmasgift_found%` | Regali trovati dal giocatore |
| `%christmasgift_rank%` | Posizione in classifica |
| `%christmasgift_<position>_name%` | Nome al posto X |
| `%christmasgift_<position>_displayname%` | Display name al posto X |
| `%christmasgift_<position>_value%` | Valore al posto X |
| `%christmasgift_total_gifts%` | Numero totale di regali nel server |
| `%christmasgift_claimed_gifts%` | Numero di regali trovati in totale |
| `%christmasgift_unclaimed_gifts%` | Numero di regali non ancora trovati |

**Esempio:** `%christmasgift_1_name%` mostra il nome del primo in classifica

## 🔬 Dettagli Tecnici

### Sistema Texture Base64

Il plugin utilizza la **riflessione Java** per applicare texture custom alle teste dei giocatori:

```java
// Il ConfigManager usa riflessione per accedere ai metodi interni di Bukkit
// e applicare texture Base64 direttamente ai blocchi PLAYER_HEAD
private void applyHeadTexture(SkullMeta meta, String textureValue) {
    // Crea un GameProfile con texture Base64
    // Usa riflessione per settare il profilo nella meta del blocco
    // Supporta tutte le versioni di Minecraft 1.20+
}
```

**Vantaggi:**
- ✅ Nessuna dipendenza da plugin esterni
- ✅ Funziona con qualsiasi texture da minecraft-heads.com
- ✅ Compatibile con tutte le versioni Spigot/Paper 1.20+
- ✅ Texture persistenti anche dopo restart

### Sistema Persistenza Dati

I dati vengono salvati in `plugins/ChristmasGift/data.yml`:

```yaml
gift-blocks:
  0:
    world: world
    x: 100.0
    y: 64.0
    z: 200.0
    claimed: true
    claimed-by: "uuid-del-giocatore"
  1:
    world: world_nether
    x: -50.0
    y: 100.0
    z: 75.0
    claimed: false
    claimed-by: null

player-stats:
  "uuid-giocatore-1": 5
  "uuid-giocatore-2": 3
  "uuid-giocatore-3": 1
```

**Caratteristiche:**
- 🔄 Salvataggio automatico ad ogni modifica
- 💾 Backup on-disable del plugin
- 🗺️ Supporto multiworld
- 📊 Statistiche per UUID (funziona anche con name change)

### Architettura del Plugin

```
ChristmasGift (Main Class)
    │
    ├─► ConfigManager      → Gestisce config.yml e creazione blocchi
    │
    ├─► MessagesManager    → Gestisce lang.yml e formattazione (i18n)
    │
    ├─► DataManager        → Gestisce data.yml e statistiche
    │       ├─► HashMap<Location, GiftBlock>
    │       └─► HashMap<UUID, Integer>
    │
    ├─► ChristmasGiftCommand → Gestisce tutti i comandi
    │       └─► TabCompleter integrato
    │
    ├─► BlockInteractListener → Gestisce eventi blocchi
    │       ├─► BlockPlaceEvent
    │       ├─► BlockBreakEvent
    │       └─► PlayerInteractEvent
    │
    └─► ChristmasGiftExpansion → PlaceholderAPI (opzionale)
            └─► Auto-register se PAPI presente
```

### Eventi e Flow

**1. Piazzamento Blocco Regalo:**
```
Admin esegue /cg give
  → ConfigManager crea ItemStack con texture
  → Blocco dato all'admin
  → Admin piazza il blocco
  → BlockPlaceEvent intercettato
  → Controllo permesso admin
  → Location salvata in DataManager
  → Salvataggio automatico in data.yml
```

**2. Claim Regalo:**
```
Giocatore click destro su blocco
  → PlayerInteractEvent intercettato
  → Verifica se è un blocco regalo
  → Controllo se già claimed
  → Controllo permesso christmasgift.claim
  → Claim eseguito
  → Incremento stats giocatore
  → Sostituzione blocco (se configurato)
  → Salvataggio automatico
  → Messaggio di conferma con totale trovati
```

**3. Generazione Leaderboard:**
```
Admin esegue /cg leaderboard
  → DataManager recupera tutte le stats
  → Ordinamento per valore decrescente
  → Lookup UUID → Nome giocatore
  → Formattazione con MessagesManager
  → Invio al richiedente
```

## 📖 Come Funziona

1. **L'admin ottiene un blocco regalo:**
   ```
   /cg give
   ```

2. **L'admin piazza il blocco regalo** dove vuole nel mondo

3. **I giocatori cercano e trovano** i blocchi regalo

4. **Click destro sul blocco** per raccoglierlo (primo arrivato, primo servito!)

5. **Il blocco viene sostituito** o rimosso (configurabile)

6. **Le statistiche vengono salvate** automaticamente in `data.yml`

7. **Usa `/cg stats`** per vedere i propri progressi

8. **Usa `/cg leaderboard`** per vedere la classifica globale

## 📦 Requisiti

- **Java**: 17+
- **Spigot/Paper**: 1.20.1+
- **Maven**: (per la compilazione)

## 🔨 Compilazione

Per compilare il plugin da sorgente:

```bash
# Clona il repository
git clone https://github.com/Fagghino/ChristmasGift.git
cd ChristmasGift

# Compila il progetto
mvn clean package
```

Il file `.jar` compilato si troverà in `target/ChristmasGift-1.0.0.jar`

## 📚 Dipendenze Maven

```xml
<dependencies>
    <!-- Spigot API (Required) -->
    <dependency>
        <groupId>org.spigotmc</groupId>
        <artifactId>spigot-api</artifactId>
        <version>1.20.1-R0.1-SNAPSHOT</version>
        <scope>provided</scope>
    </dependency>
    
    <!-- PlaceholderAPI (Optional - Auto-detected) -->
    <dependency>
        <groupId>me.clip</groupId>
        <artifactId>placeholderapi</artifactId>
        <version>2.11.3</version>
        <scope>provided</scope>
    </dependency>
</dependencies>
```

### Repository

```xml
<repositories>
    <!-- Spigot Repository -->
    <repository>
        <id>spigot-repo</id>
        <url>https://hub.spigotmc.org/nexus/content/repositories/snapshots/</url>
    </repository>
    
    <!-- PlaceholderAPI Repository -->
    <repository>
        <id>placeholderapi</id>
        <url>https://repo.extendedclip.com/releases/</url>
    </repository>
</repositories>
```

**Note:**
- Tutte le dipendenze usano `scope: provided` perché sono fornite dal server
- PlaceholderAPI è completamente opzionale e viene rilevata automaticamente a runtime
- Non sono necessarie dipendenze esterne per il supporto texture Base64

## 🎯 Struttura del Progetto

```
ChristmasGift/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/
│       │       └── franchino961/
│       │           └── christmasgift/
│       │               ├── ChristmasGift.java              # Classe principale del plugin
│       │               ├── commands/
│       │               │   └── ChristmasGiftCommand.java   # Gestione comandi e tab completion
│       │               ├── config/
│       │               │   ├── ConfigManager.java          # Gestione config.yml e texture
│       │               │   └── MessagesManager.java        # Gestione lang.yml (i18n)
│       │               ├── data/
│       │               │   ├── DataManager.java            # Persistenza dati e statistiche
│       │               │   └── GiftBlock.java              # Classe modello per blocchi regalo
│       │               ├── listeners/
│       │               │   └── BlockInteractListener.java  # Eventi blocchi (place/break/claim)
│       │               └── placeholders/
│       │                   └── ChristmasGiftExpansion.java # Integrazione PlaceholderAPI
│       └── resources/
│           ├── plugin.yml     # Configurazione plugin, comandi e permessi
│           ├── config.yml     # Configurazione blocchi regalo
│           └── lang.yml       # Traduzioni (en_us, it_it)
├── target/
│   └── ChristmasGift-1.0.0.jar  # JAR compilato
├── pom.xml                      # Configurazione Maven
├── LICENSE                      # Licenza MIT
└── README.md                    # Questo file
```

## 🐛 Troubleshooting

### Il blocco non ha la texture personalizzata

1. Verifica che hai copiato il "Value" corretto da minecraft-heads.com (non l'URL!)
2. Assicurati che `type: PLAYER_HEAD` sia impostato nel config.yml
3. Usa `/cg reload` dopo aver modificato la configurazione
4. Controlla che la stringa Base64 sia completa e tra virgolette

### I giocatori non possono raccogliere i regali

1. Verifica che abbiano il permesso `christmasgift.claim`
2. Controlla che i regali non siano già stati raccolti
3. Verifica nei log del server per eventuali errori

### Le statistiche non vengono salvate

1. Controlla che il plugin abbia i permessi di scrittura nella cartella `plugins/ChristmasGift/`
2. Verifica che il file `data.yml` non sia corrotto
3. Controlla i log del server per errori di I/O

## 💡 Esempi Pratici

### Scenario 1: Evento Caccia al Tesoro Natalizio

**Setup:**
```yaml
# config.yml
gift-block:
  type: PLAYER_HEAD
  display-name: "&c&l🎁 &f&lRegalo di Natale &c&l🎁"
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
  replace-after-claim: true
  replacement-block:
    type: SNOW_BLOCK  # Sostituisce con neve
```

**Comandi:**
```bash
# Admin ottiene 20 blocchi regalo
/cg give  # Ripeti 20 volte o usa un loop

# Admin nasconde i blocchi nella mappa
# (piazzamento manuale in luoghi creativi)

# Annuncia l'evento
/broadcast §c§l[Natale] §aL'evento Caccia ai Regali è iniziato!
/broadcast §eTrovate tutti i §c20 regali §enascosti nel server!

# Controlla progresso
/cg leaderboard
```

**Con PlaceholderAPI + DeluxeMenus:**
```yaml
# Menu che mostra progresso live
menu-item:
  material: PLAYER_HEAD
  display_name: "&c&lRegali di Natale"
  lore:
    - ""
    - "&eTu hai trovato: &a%christmasgift_found% regali"
    - "&eLa tua posizione: &6#%christmasgift_rank%"
    - ""
    - "&7Regali totali: &e%christmasgift_total_gifts%"
    - "&7Regali trovati: &a%christmasgift_claimed_gifts%"
    - "&7Regali rimanenti: &c%christmasgift_unclaimed_gifts%"
    - ""
    - "&6&lTop 3:"
    - "&e1. &f%christmasgift_1_displayname% &7- &a%christmasgift_1_value%"
    - "&e2. &f%christmasgift_2_displayname% &7- &a%christmasgift_2_value%"
    - "&e3. &f%christmasgift_3_displayname% &7- &a%christmasgift_3_value%"
```

### Scenario 2: Sistema Rewards Personalizzato

**Setup con plugin rewards:**

1. **Installa un plugin come ExecutableItems o CommandBlocks**
2. **Configura rewards basati su statistiche:**

```yaml
# Esempio con Quests plugin
quests:
  christmas-beginner:
    display: "&aPrimo Cercatore"
    requirements:
      placeholder:
        - "%christmasgift_found% >= 1"
    rewards:
      commands:
        - "give %player% diamond 5"
        - "title %player% title {"text":"Primo Regalo!","color":"green"}"
  
  christmas-explorer:
    display: "&6Esploratore Natalizio"
    requirements:
      placeholder:
        - "%christmasgift_found% >= 5"
    rewards:
      commands:
        - "give %player% emerald 10"
        - "eco give %player% 1000"
  
  christmas-master:
    display: "&c&lMaestro del Natale"
    requirements:
      placeholder:
        - "%christmasgift_found% >= 10"
    rewards:
      commands:
        - "give %player% elytra 1"
        - "crate give %player% legendary 1"
```

### Scenario 3: Reset Periodico Automatico

**Con plugin scheduler come Task Scheduler:**

```yaml
# Reset settimanale ogni domenica a mezzanotte
tasks:
  weekly-reset:
    time: "0 0 * * SUN"
    commands:
      - "cg removeall"
      - "cg resetall"
      - "broadcast §c§l[ChristmasGift] §eEvento resettato! Nuovi regali disponibili!"
```

**O con cron job del server:**
```bash
#!/bin/bash
# reset-gifts.sh
rcon-cli "cg removeall"
rcon-cli "cg resetall"
rcon-cli "broadcast §aNuova settimana, nuova caccia ai regali!"

# In crontab:
# 0 0 * * SUN /path/to/reset-gifts.sh
```

### Scenario 4: Permessi per Evento VIP

**Setup permessi con LuckPerms:**

```bash
# Solo VIP possono raccogliere regali
/lp group default permission set christmasgift.claim false
/lp group vip permission set christmasgift.claim true

# Messaggi personalizzati
# In lang.yml (sezione della tua lingua)
no-permission: "&c&lAccesso Negato! &7Solo i membri &6VIP &7possono partecipare all'evento Natalizio!"
```

**Annuncio ai giocatori:**
```yaml
# Con Announcer plugin
announcements:
  christmas-event:
    interval: 600  # Ogni 10 minuti
    messages:
      - ""
      - "&c&l🎄 EVENTO NATALIZIO 🎄"
      - "&e%christmasgift_unclaimed_gifts% regali ancora disponibili!"
      - "&7Diventa &6VIP &7per partecipare!"
      - "&astore.tuoserver.it"
      - ""
```

### Scenario 5: Integrazione con Dynmap

**Mostra marker sulla mappa (richiede plugin custom o Citizens):**

```java
// Esempio concettuale - richiede sviluppo custom
public void addGiftMarkers() {
    MarkerAPI markerAPI = dynmap.getMarkerAPI();
    MarkerSet giftSet = markerAPI.createMarkerSet("gifts", "Regali di Natale", null, false);
    
    for (Location loc : dataManager.getUnclaimedGiftLocations()) {
        giftSet.createMarker(
            "gift_" + loc.hashCode(),
            "🎁 Regalo Nascosto",
            loc.getWorld().getName(),
            loc.getX(),
            loc.getY(),
            loc.getZ(),
            markerAPI.getMarkerIcon("gift"),
            false
        );
    }
}
```

## 💡 Esempio Configurazione Completa

```yaml
gift-block:
  type: PLAYER_HEAD
  display-name: "&c&l🎁 &a&lRegalo di Natale &c&l🎁"
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
  
  replace-after-claim: true
  
  replacement-block:
    type: AIR
```

## 📄 Licenza

Questo progetto è rilasciato sotto licenza MIT. Vedi il file [LICENSE](LICENSE) per maggiori dettagli.

## 👤 Autore

**Fagghino**

- GitHub: [@Fagghino](https://github.com/Fagghino)

## 🤝 Contribuire

Contributi, problemi e richieste di funzionalità sono benvenuti!
Sentiti libero di controllare la [pagina delle issues](../../issues).

## 📝 Changelog

### v1.3.0 - Placeholder Globali
- ➕ **Aggiunti placeholder globali per statistiche server**
  - `%christmasgift_total_gifts%` - Conteggio totale regali nel server
  - `%christmasgift_claimed_gifts%` - Regali trovati globalmente
  - `%christmasgift_unclaimed_gifts%` - Regali ancora da trovare
- 🔧 Aggiunti metodi `getTotalGifts()`, `getClaimedGifts()`, `getUnclaimedGifts()` in DataManager
- 📖 Documentazione PlaceholderAPI aggiornata con nuovi placeholder
- ✨ Maggiore controllo sullo stato globale dell'evento

### v1.2.0 - Sistema Permessi Granulare
- ➕ **Aggiunto permesso `christmasgift.claim`**
  - Controllo granulare su chi può raccogliere i regali
  - Default: tutti i giocatori
  - Permette agli admin di limitare la partecipazione all'evento (es. solo VIP)
- 🔧 Aggiunto controllo permesso in BlockInteractListener prima del claim
- 📖 Documentazione permessi aggiornata con nuova tabella
- 📖 Sezione "Come Funziona" aggiornata per menzionare il permesso
- 🎯 Esempi pratici per eventi VIP nella documentazione

### v1.1.0 - Comandi Reset Statistiche
- ➕ **Aggiunti comandi admin per reset statistiche**
  - `/cg reset <player>` - Reset statistiche singolo giocatore
  - `/cg resetall` - Reset tutte le statistiche globali
- 🔧 Implementati metodi `resetPlayerStats()` e `resetAllPlayerStats()` in DataManager
- 🔧 Messaggi di conferma con conteggio regali precedenti
- 📖 README aggiornato con tabella comandi completa
- 🎮 Gestione eventi ricorrenti facilitata (reset settimanali/mensili)

### v1.0.0 - Release Iniziale
- 🎉 **Prima release pubblica stabile**
- 🎁 **Sistema blocchi regalo completo**
  - Piazzamento blocchi da parte admin con `/cg give`
  - Click destro per claim da parte giocatori
  - Sostituzione blocco configurabile dopo il claim
  - Supporto texture Base64 custom senza dipendenze esterne
- 💾 **Sistema persistenza dati**
  - Salvataggio automatico in `data.yml`
  - Tracciamento blocchi e statistiche giocatori
  - Supporto multiworld
  - Statistiche basate su UUID (compatibile con cambio nome)
- 📊 **Sistema classifica e statistiche**
  - Leaderboard ordinata per regali trovati
  - Comando `/cg stats` per statistiche personali
  - Comando `/cg leaderboard` per classifica globale
- 🔌 **Integrazione PlaceholderAPI (opzionale)**
  - 8 placeholder disponibili (found, rank, top player stats)
  - Auto-rilevamento e registrazione automatica
  - Funziona completamente anche senza PAPI
- ⚙️ **8 comandi admin completi**
  - `/cg give` - Ottenere blocchi regalo
  - `/cg stats` - Visualizzare statistiche
  - `/cg leaderboard` - Mostrare classifica
  - `/cg remove <x> <y> <z>` - Rimuovere blocchi specifici
  - `/cg removeall` - Rimuovere tutti i blocchi
  - `/cg reload` - Ricaricare configurazione
  - Tab completion integrato per tutti i comandi
- 🔑 **Sistema permessi**
  - `christmasgift.use` - Comandi base (default: tutti)
  - `christmasgift.admin` - Comandi admin (default: op)
- 🎨 **Supporto texture personalizzate**
  - Sistema riflessione Java per texture Base64
  - Compatibile con minecraft-heads.com
  - Nessun plugin esterno richiesto (HeadDatabase non necessario)
  - Funziona su Spigot/Paper 1.20+
- 📝 **Configurazione completa**
  - `config.yml` per impostazioni blocchi regalo
  - `lang.yml` per traduzioni (en_us, it_it)
  - Supporto colori con `&`
  - Sistema multi-lingua (inglese e italiano)
- 🏗️ **Architettura modulare**
  - ConfigManager per gestione configurazione
  - MessagesManager per messaggi
  - DataManager per persistenza dati
  - BlockInteractListener per eventi
  - ChristmasGiftExpansion per PlaceholderAPI
- 📖 **Documentazione completa**
  - README dettagliato con esempi
  - Guide setup e troubleshooting
  - Esempi integrazione con altri plugin

## ⭐ Supporto

Se trovi utile questo plugin, considera di lasciare una stella ⭐ al repository!

## 🔗 Link Utili

- [minecraft-heads.com](https://minecraft-heads.com/) - Database di teste personalizzate
- [PlaceholderAPI](https://www.spigotmc.org/resources/6245/) - Plugin per placeholder
- [Spigot Resources](https://www.spigotmc.org/) - Risorse per server Minecraft
