# No Man's Sky Save Editor — Architecture

## Entry Point
`Application.java` — Swing JFrame application. Singleton via `getInstance()`.  
`AppStartupRunnable` (`w`) — initializes FlatLaf theme and shows main window.

## Save I/O Layer
| Class | Role |
|---|---|
| `SaveLocation` (`fq`) | Interface: factory for save formats |
| `SteamSaveLocation` (`fJ`) | Steam PC saves |
| `XboxSaveLocation` (`fT`) | Xbox `containers.index` format |
| `PS4SaveLocation` (`fA`) | PS4 Save Wizard `.hg` files |
| `SaveSlot` (`ft`) | Interface: one save slot |
| `SaveFile` (`fs`) | Interface: one save file |
| `SteamSaveFileMetadata` (`fQ`) | Steam save metadata |
| `SaveFileMetadata` (`fI`) | Generic metadata |
| `XboxContainerWriter` (`fX`) | Writes Xbox container format |
| `FileWatcher` (`fl`) / `FileWatcherThread` (`fm`) | Watches save folder for external changes |
| `AccountData` (`fr`) | Account-level data (cross-save) |
| `InMemorySaveFile` (`F`) | In-memory save for editing |

## JSON Layer
| Class | Role |
|---|---|
| `JsonParser` (`fh`) | Parses JSON; static `Q()` entry point |
| `JsonWriter` (`fj`) | Serializes JSON |
| `JsonObject` (`eY`) | JSON object node (names/values arrays) |
| `JsonArray` (`eV`) | JSON array node |
| `JsonParseException` (`eX`) | Parse error |
| `BinaryReader` (`ff`) | Reads NMS binary save format |
| `SpookyHash` (`hh`) | SpookyHash for save checksums |

## Game Model Layer
| Class | Role |
|---|---|
| `Exosuit` (`gz`) | Player exosuit data |
| `Multitool` (`gv`) | Multitool data |
| `Starship` (`gH`) | Starship data |
| `SquadronPilot` (`gM`) | Squadron pilot |
| `Freighter` (`gm`) | Freighter data |
| `Frigate` (`gp`) | Frigate data |
| `Vehicle` (`gO`) | Vehicle (Exocraft) data |
| `Companion` (`gj`) | Companion creature data |
| `Settlement` (`ge`) | Settlement data |
| `Base` (`gf`) | Base building data |
| `Inventory` (`gt`) | Generic inventory |
| `ItemData` (`gQ`) | Item stack data |
| `ItemDefinition` (`ey`) | Item type definition |

## Enums
`ShipType` (`gL`), `ShipClass` (`gN`), `FreighterType` (`go`), `MultitoolType` (`gx`), `FrigateClass` (`gr`), `NpcRace` (`gd`), `CompanionGenus` (`gk`), `GameMode` (`fn`), `Race` (`eU`)

## UI Panels (tabs in main window)
| Class | Tab |
|---|---|
| `ExosuitPanel` (`aJ`) | Exosuit |
| `MultitoolPanel` (`dj`) | Multitool |
| `ShipsPanel` (`dN`) | Ships |
| `SquadronPanel` (`eb`) | Squadron |
| `FreighterPanel` (`bd`) | Freighter |
| `FrigatesPanel` (`bl`) | Frigates |
| `VehiclesPanel` (`ep`) | Vehicles |
| `CompanionsPanel` (`X`) | Companions |
| `BasesStoragePanel` (`I`) | Bases/Storage |
| `SettlementsPanel` (`dE`) | Settlements |
| `DiscoveryPanel` (`ap`) | Discovery |
| `MilestonesPanel` (`bE`) | Milestones |
| `AccountPanel` (`c`) | Account |

## UI Utilities
`InventoryPanel` (`bO`), `InventorySlotPanel` (`bS`), `FormPanel` (`ba`), `SplitFormPanel` (`em`), `LineNumberPanel` (`cW`), `ValidatedTextField` (`G`), `SlotComboBoxModel` (`D`), `FileComboBoxModel` (`E`)

## Dialogs
`JsonEditorDialog` (`cy`), `ItemDetailsDialog` (`cg`), `AboutDialog` (`a`)

## Infrastructure
`Logger` (`hc`), `AppSettings` (`aH`), `BackupUtil` (`gS`), `TemplateLoader` (`gR`), `GalacticAddress` (`hl`), `CoordinateTransform` (`gT`), `UpdateCheckThread` (`x`), `UpdateDownloadRunnable` (`y`)
