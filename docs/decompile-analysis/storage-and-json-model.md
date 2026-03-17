# Storage and JSON model types (decompiled)

Date: 2026-03-17  
Branch: `decompile-analysis`

This note documents key obfuscated types used by `nomanssave.Application`.

## Storage abstraction: `fq`

### What it is
`fq` is a storage-provider interface that abstracts how No Man’s Sky saves are stored on disk for different platforms.

Platform implementations detected:
- `fJ` -> Steam
- `fT` -> Xbox Game Pass
- `fA` -> PS4 - Save Wizard

### Factory methods
- `static fq a(File pathOrFile, fR watcher)`
  - Auto-detects provider by scanning a directory or a given file name.
  - Detection rules (high-level):
    - `containers.index` => Xbox Game Pass (`fT`)
    - `accountdata.hg` or `save*.hg` => Steam (`fJ`)
    - `savedata\d{2}.hg` => PS4 Save Wizard (`fA`)

- `static fq a(String storageName, File saveDir, fR watcher)`
  - Instantiates the provider explicitly from a known storage name.

- `static String c(fq storage)`
  - Returns the UI display name for a storage instance (`Steam`, `Xbox Game Pass`, `PS4 - Save Wizard`).

### Primary instance methods
- `File bS()` -> save root directory
- `fr bT()` -> read account data wrapper
- `ft[] bU()` -> all slots (including empty)
- `ft[] bV()` -> non-empty slots (default helper)
- `int W(String filename)` -> map save filename to slot index
- `boolean bW()` -> whether Save-As is supported (default false)
- `String a(int slotIndex, eY saveJson)` -> create/copy save into a slot (default throws)
- `void X(String ...)` -> unknown from interface alone; inspect implementations

### Suggested rename
- `fq` -> `SaveStorage` / `GameStorage`

## Slot abstraction: `ft`
Represents a “game slot” within a storage provider.

Methods:
- `getIndex()`
- `isEmpty()`
- `fn L()` -> mode/difficulty preset
- `fs[] bX()` -> save files for slot

Suggested rename:
- `ft` -> `GameSlot`

## Save file abstraction: `fs`
Represents a concrete save file entry within a slot.

Methods:
- `String K()` -> filename / identifier
- `fn L()` -> mode/difficulty preset
- `eY M()` -> load/parse JSON
- `String b(eY obj)` -> write JSON and return filename/id
- `long lastModified()`
- `getName()`, `getDescription()` -> optional UI metadata

Suggested rename:
- `fs` -> `SaveFileEntry`

## JSON object model: `eY` and `eV`

### `eY` (object)
Custom JSON object with:
- deep copy: `bE()`
- string output: `bz()` pretty, `toString()` compact-ish
- path access: `getValue("A.B[0].C")`, helpers `H(path)` (object), `d(path)` (array)
- typed getters: `J(path)` int, `K(path)` long, `L(path)` double, `M(path)` boolean, etc.
- set by path: `b(path, value)` / `c(path, value)` (different semantics)
- file I/O: `c(File)` write, `d(File)` read into this object
- change propagation:
  - one listener `fe` (`a(fe listener)`)
  - parent container `kD` (propagates nested changes upward)

Suggested rename:
- `eY` -> `JsonObject` / `NmsJsonObject`

### `eV` (array)
Custom JSON array with:
- deep copy: `bA()`
- mutation: add/set/remove with parent change propagation (`kD`)
- typed element getters: `Y(i)` int, `Z(i)` long, `X(i)` string

Suggested rename:
- `eV` -> `JsonArray` / `NmsJsonArray`

## Change listener: `fe`
Callback:
- `propertyChanged(String path, Object oldValue, Object newValue)`

Suggested rename:
- `fe` -> `JsonChangeListener` / `PropertyChangeListener`