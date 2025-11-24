
# ChristmasGift Plugin

Un plugin Minecraft per Spigot/Paper che permette di creare una caccia al tesoro natalizia con blocchi regalo nascosti.

## ✅ Compilazione Riuscita!

Il plugin è stato compilato con successo e si trova in:
```
target/ChristmasGift-1.0.0.jar
```

## 🎁 Tutte le Funzionalità Disponibili

### ✅ Cosa funziona:
✅ Tutti i comandi (`/cg give`, `/cg stats`, `/cg leaderboard`, ecc.)  
✅ Sistema di piazzamento e claim dei blocchi regalo  
✅ Salvataggio dati in `data.yml`  
✅ Sistema di classifica  
✅ Configurazione completa in `config.yml` e `messages.yml`  
✅ Supporto blocchi normali (DIAMOND_BLOCK, GOLD_BLOCK, ecc.)  
✅ **Supporto COMPLETO per texture Base64 custom!** 🎨

### Passaggi:

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

## 📦 Installazione sul Server

1. Copia `target/ChristmasGift-1.0.0.jar` nella cartella `plugins/` del tuo server
2. (Opzionale) Installa PlaceholderAPI se vuoi i placeholder
3. Avvia il server
4. Configura `config.yml` e `messages.yml` nella cartella `plugins/ChristmasGift/`
5. Imposta una texture personalizzata (vedi sopra)
6. Usa `/cg give` per ottenere un blocco regalo


## 🎮 Comandi Principali

- `/cg give` - Ottieni un blocco regalo (admin)
- `/cg stats` - Mostra le tue statistiche
- `/cg leaderboard` - Mostra la classifica (admin)
- `/cg remove <x> <y> <z>` - Rimuovi un blocco regalo (admin)
- `/cg removeall` - Rimuovi tutti i blocchi (admin)
- `/cg reset <player>` - Reset delle statistiche di un giocatore (admin)
- `/cg resetall` - Reset di tutte le statistiche dei giocatori (admin)
- `/cg reload` - Ricarica la configurazione (admin)

## 📝 Permessi

- `christmasgift.use` - Comandi base (default: tutti)
- `christmasgift.admin` - Comandi admin (default: op)

## 🎄 Esempio Configurazione Natalizia

```yaml
gift-block:
  type: PLAYER_HEAD
  display-name: "&c&l🎁 &a&lRegalo di Natale &c&l🎁"
  # Texture di un regalo natalizio (esempio da minecraft-heads.com)
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
  
  replace-after-claim: true
  
  replacement-block:
    type: AIR
```

## ℹ️ Supporto PlaceholderAPI (Opzionale)

Per abilitare i placeholder:

Se hai PlaceholderAPI installato sul server, i placeholder sono già disponibili e funzionanti:

- `%christmasgift_found%` - Regali trovati dal giocatore
- `%christmasgift_rank%` - Posizione in classifica
- `%christmasgift_<position>_name%` - Nome al posto X
- `%christmasgift_<position>_displayname%` - Display name al posto X
- `%christmasgift_<position>_value%` - Valore al posto X

Non sono necessarie modifiche manuali: il plugin rileva automaticamente PlaceholderAPI e abilita i placeholder.

---

**Il plugin è completamente funzionante con texture personalizzate!** 🎄🎁

## Requisiti

- Java 17
- Minecraft 1.20.x
- Spigot/Paper 1.20.x
- Maven per la compilazione

## Dipendenze Opzionali

- **PlaceholderAPI** - Per i placeholder (https://www.spigotmc.org/resources/6245/)

## Supporto Texture Custom

Il plugin supporta **texture Base64** per le teste dei blocchi regalo senza bisogno di plugin esterni!

Per usare una testa personalizzata:
1. Vai su https://minecraft-heads.com/ o simili
2. Cerca la testa che vuoi
3. Copia il valore "Value" (Base64)
4. Incollalo nel `config.yml` sotto `gift-block.head-texture`

Esempio:
```yaml
gift-block:
  type: PLAYER_HEAD
  head-texture: "eyJ0ZXh0dXJlcyI6eyJTS0lOIjp7InVybCI6Imh0dHA6Ly90ZXh0dXJlcy5taW5lY3JhZnQubmV0L3RleHR1cmUvZDFjYTMxMWFmYTlhOTBmYzBmZmFkYWQzMGNkZTA5NGI4M2RmYTQxNjRkZGM0ZjhmZTA5MzUxZDlhYzQ5YzY4MyJ9fX0="
```

## Compilazione

```bash
mvn clean package
```

Il file JAR compilato si troverà nella cartella `target/`.

## Installazione

1. Scarica PlaceholderAPI (opzionale ma consigliato)
2. Metti il file JAR del plugin nella cartella `plugins/` del tuo server
3. Riavvia il server
4. Configura il plugin nei file `config.yml` e `messages.yml`
5. Imposta una texture custom se desiderato (vedi sezione sopra)

## Comandi

### Comandi per tutti i giocatori:
- `/christmasgift stats` - Mostra le tue statistiche (quanti regali hai trovato)

### Comandi per amministratori:
- `/christmasgift give` - Ricevi un blocco regalo da piazzare
- `/christmasgift leaderboard` (o `/cg lb`) - Mostra la classifica
- `/christmasgift remove <x> <y> <z>` - Rimuovi un blocco regalo specifico
- `/christmasgift removeall` - Rimuovi tutti i blocchi regalo
- `/christmasgift reload` - Ricarica la configurazione

Alias disponibili: `/cg`, `/gift`

## Permessi

- `christmasgift.use` - Permette di usare i comandi base (default: tutti)
- `christmasgift.admin` - Permette di usare i comandi admin (default: op)

## PlaceholderAPI

Il plugin supporta i seguenti placeholder:

- `%christmasgift_found%` - Numero di regali trovati dal giocatore
- `%christmasgift_rank%` - Posizione del giocatore nella classifica
- `%christmasgift_<position>_name%` - Nome del giocatore in posizione X
- `%christmasgift_<position>_displayname%` - Display name del giocatore in posizione X
- `%christmasgift_<position>_value%` - Numero di regali trovati dal giocatore in posizione X

Esempio: `%christmasgift_1_name%` mostra il nome del primo in classifica

## Configurazione

### config.yml

Il file `config.yml` permette di configurare:
- Tipo di blocco regalo (normale o player head)
- Texture Base64 per head personalizzate (da minecraft-heads.com)
- Nome visualizzato del blocco
- Se sostituire il blocco dopo il claim
- Tipo di blocco sostitutivo

### messages.yml

Tutti i messaggi del plugin sono personalizzabili nel file `messages.yml`.
Supporta i colori con il simbolo `&`.

## Come funziona

1. L'admin usa `/christmasgift give` per ottenere un blocco regalo
2. L'admin piazza il blocco regalo dove vuole nel mondo
3. I giocatori trovano il blocco e ci cliccano sopra con il tasto destro
4. Il primo giocatore che clicca riscuote il regalo
5. Il blocco viene sostituito o rimosso (configurabile)
6. Le statistiche vengono salvate e aggiornate

## Funzionalità principali

- ✅ Supporto per blocchi normali e player head custom con texture Base64
- ✅ Texture personalizzate da minecraft-heads.com (senza plugin aggiuntivi!)
- ✅ Sistema di classifica
- ✅ Statistiche per giocatore
- ✅ Salvataggio automatico dei dati
- ✅ Placeholders per PlaceholderAPI (opzionale)
- ✅ Messaggi completamente personalizzabili
- ✅ Supporto per blocchi sostitutivi
- ✅ Comandi con tab completion

## Supporto

Per bug o suggerimenti, apri una issue su GitHub.

## Licenza

Vedi file LICENSE
