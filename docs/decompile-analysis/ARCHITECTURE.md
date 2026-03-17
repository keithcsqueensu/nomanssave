# Architecture

## Architectural Analysis Notes

- Add consolidated notes here.

## Deprecation convention (Java 11/17 baseline)

This repository uses Java 11/17, so we standardize on the Java 9+ deprecation metadata.

### Baseline annotation

Use the following as the default for deprecated code during decompile/rename refactors:

```java
/**
 * @deprecated Use {@code <Replacement>} instead.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
```

- `since` is pinned to `2026-03-17` to match the start of the decompile-analysis effort.
- `forRemoval = false` means: “avoid new usages; existing usages are still supported; removal is not scheduled yet.”

### When to set forRemoval=true

Use `forRemoval = true` only when all of the following are true:

1. There is a clear replacement API/type already in the codebase.
2. Call sites can reasonably migrate (or migration is already done).
3. We intend to delete the deprecated code in a future cleanup pass.

Recommended form:

```java
/**
 * @deprecated Use {@link NewThing} instead. Scheduled for removal.
 */
@Deprecated(since = "2026-03-17", forRemoval = true)
```

### Documentation requirements

Whenever `@Deprecated` is used:

- Include a Javadoc `@deprecated` tag.
- Name the replacement (link it via `{@link ...}` when possible).
- If the replacement is not 1:1, document the migration notes briefly (what changed, any behavior differences).

### Non-Javadoc contexts

For non-public members or where Javadoc isn’t present, still add a concise comment directly above the annotation describing the replacement.

## Ongoing Notes

- Add ongoing notes here.