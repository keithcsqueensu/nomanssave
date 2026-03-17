# Decompiled code analysis (work notes)

Branch: `decompile-analysis`

This folder contains running architectural/functional analysis notes while working through decompiled/obfuscated Java sources in this repository.

## 2026-03-17 – Application.java (nomanssave/Application.java)

### Summary
`nomanssave.Application` is the top-level Swing GUI controller / orchestrator for the No Man’s Sky save editor.

It mixes responsibilities that would normally be separated:
- App bootstrap (`main`)
- UI composition (`initialize()`)
- Session state (selected storage/slot/save file)
- Persistence (save/account writeback)
- Domain operations (import/export, backup/restore)
- Dirty tracking and external-modification prompts

### Key state (high confidence)
- **Storage**: `fq aF` – abstraction over where saves live and how to read/write them.
- **Game slots**: `ft[] aG` with selected slot index `int aH`.
- **Save files (per slot)**: `fs[] aI` with selected file index `int aJ`.
- **Loaded save JSON**: `eY aK`.
- **Dirty flag (save)**: `boolean aL` (set by save JSON change listener).
- **Account data file**: `fr aM` and **account JSON**: `eY aN`.
- **Dirty flag (account)**: `boolean aO`.

### UI components (high confidence)
- `JFrame N` – main application window.
- `JTabbedPane O` – main tabs.
- Labels: storage (`P`), path (`Q`), modified (`T`), save name (`U`), description (`V`).
- Combos: slot picker (`R`), save file picker (`S`).
- Buttons: reload (`W`), save (`X`), save-as (`Y`).
- Menu items: reload (`Z`), save (`aa`), save-as (`ab`), edit-account-json (`ad`).
- `List ac` – menu items that are enabled only when a save is loaded.

### Startup flow
1. Parse `-autoupdate` argument.
2. `nomanssave.aH.init(!autoupdate)`.
3. Start background thread calling `cK.aA()`.
4. Start Swing UI via `EventQueue.invokeLater(new w(autoupdate))`.

### Core methods
- `initialize()` – constructs the entire UI (tabs, menus, bindings).
- `k()` – “Open File/Path”: choose storage folder/file and reload storage + account.
- `l()` – reload selected save file into `aK`, install change listener, and repopulate all tabs.
- `n()` – save current `aK` back to disk.
- `o()` – save-as / create new slot copy.
- `m()` – save account JSON.
- `u()` / `v()` – export/import JSON.

### External change handling
Method `f()` processes flags that trigger:
- slot list reload
- save file list reload
- prompt to reload if file deleted/modified externally

### Next recommended analysis steps
Before renaming fields/vars in `Application.java`, identify the meaning of key obfuscated types by inspecting:
- `fq` (storage)
- `ft` (slot)
- `fs` (save file)
- `eY` / `eV` (JSON wrapper object/array)
- `fe` (change listener interface)
- `w` (startup Runnable)

This makes renaming much more accurate and avoids inconsistent terminology.

### Candidate rename map (first-pass)
These are suggested names based on usage in `Application.java` alone; update after inspecting the types above.

#### UI fields
- `N` → `mainFrame`
- `O` → `mainTabs`
- `P` → `storageLabel`
- `Q` → `savePathLabel`
- `R` → `slotCombo`
- `S` → `saveFileCombo`
- `T` → `modifiedLabel`
- `U` → `saveNameLabel`
- `V` → `descriptionLabel`
- `W` → `reloadButton`
- `X` → `saveButton`
- `Y` → `saveAsButton`
- `Z` → `reloadMenuItem`
- `aa` → `saveMenuItem`
- `ab` → `saveAsMenuItem`
- `ac` → `saveDependentMenuItems`
- `ad` → `editAccountJsonMenuItem`

#### Session/model fields
- `aF` → `storage`
- `aG` → `gameSlots`
- `aH` → `selectedSlotIdx`
- `aI` → `slotSaveFiles`
- `aJ` → `selectedSaveFileIdx`
- `aK` → `saveJson`
- `aL` → `saveDirty`
- `aM` → `accountData`
- `aN` → `accountJson`
- `aO` → `accountDirty`
- `aP` → `shouldPromptSaveAccount`

---

## How to add new notes
- Create a new dated section in this README, or add a new markdown file per class (e.g. `Application.md`, `fq.md`) if it gets too large.