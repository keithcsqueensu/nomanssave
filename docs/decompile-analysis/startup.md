# Startup flow (decompiled)

Date: 2026-03-17  
Branch: `decompile-analysis`

## `Application.main(...)`
Startup sequence:
1. Parse `-autoupdate` argument.
2. Initialize settings via `nomanssave.aH.init(!autoupdate)`.
3. Start a background thread calling `cK.aA()` (likely preload/update/initialization).
4. Start Swing UI on the EDT via `EventQueue.invokeLater(new w(autoupdate))`.

## `w` (startup Runnable)
`nomanssave.w` is the Swing startup `Runnable`.

Behavior:
- Constructs the app: `new Application(autoupdateFlag, null)`
- Assigns it to the singleton instance
- Shows the frame
- On exception: prints stack trace and exits with `System.exit(1)`