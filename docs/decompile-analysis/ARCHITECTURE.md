# Architecture

## Architectural Analysis Notes

- Add consolidated notes here.

## Deprecation convention (tight / mechanical; Java 11/17 baseline)

### Quick checklist (PR reviewer)

- [ ] Every `@Deprecated` includes `since = "2026-03-17"` and an explicit `forRemoval = ...`.
- [ ] There is a Javadoc `@deprecated` tag that starts with **"Use ... instead."**
- [ ] The replacement is named (prefer `{@link ...}` / `{@link Type#member}`; otherwise `{@code ...}`).
- [ ] Rename deprecations delegate to the new API (no duplicated logic).
- [ ] `forRemoval = true` is only used when replacement exists and migration is feasible/planned.

### 0) Baseline constants (do not vary)

- **Date stamp**: `since = "2026-03-17"`
- **Default removal intent**: `forRemoval = false`
- **Every deprecation must state a replacement** (even if the replacement is “new name is TBD”; see “TBD replacement” rule below).

---

### 1) Decision tree: should this be deprecated?

Deprecate an API/member when **any** of the following is true:

- It is an **old/obfuscated name** being superseded by a clearer name (`a()` → `parseSaveJson()`).
- It is a **temporary compatibility shim** (wrapper delegating to the new thing).
- It is a **bad abstraction** we don’t want new code to use, but can’t delete yet.

Do **not** deprecate when:

- You’re still actively iterating and there is no stable replacement name yet (unless you use the “TBD replacement” form below).
- The member is private and will be deleted immediately in the same change set (just delete it).

---

### 2) Required format (always)

When you add `@Deprecated`, you must add **all** of the following:

**A. Javadoc `@deprecated` tag**

- Must start with: `@deprecated Use ... instead.`

**B. The annotation with metadata**

Default:

```java
@Deprecated(since = "2026-03-17", forRemoval = false)
```

**C. Replacement reference**

- Prefer `{@link Type}` / `{@link Type#member}` for public/protected/package-private APIs.
- Use `{@code ...}` for non-linkable names (e.g., “field path strings”, JSON keys, or if the replacement doesn’t exist yet).

---

### 3) Templates (copy/paste)

#### 3.1 Class / interface / enum

```java
/**
 * @deprecated Use {@link NewType} instead.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
public class OldType { ... }
```

#### 3.2 Method (same signature replacement)

```java
/**
 * @deprecated Use {@link #newMethod(Type1, Type2)} instead.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
public ReturnType oldMethod(Type1 a, Type2 b) {
    return newMethod(a, b);
}
```

#### 3.3 Method (replacement is elsewhere)

```java
/**
 * @deprecated Use {@link OtherType#newMethod(...)} instead.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
public ReturnType oldMethod(...) { ... }
```

#### 3.4 Field / constant

```java
/**
 * @deprecated Use {@link #NEW_NAME} instead.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
public static final int OLD_NAME = NEW_NAME;
```

#### 3.5 Constructor

```java
/**
 * @deprecated Use {@link #NewType(Arg1, Arg2)} instead.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
public OldType(Arg1 a, Arg2 b) { ... }
```

---

### 4) “TBD replacement” rule (allowed, but constrained)

If you need to discourage new usage **before** the final name exists, you may still deprecate, but you must use this exact wording:

```java
/**
 * @deprecated Replacement pending rename/deobfuscation; avoid new usage.
 */
@Deprecated(since = "2026-03-17", forRemoval = false)
```

Constraint: once the replacement exists, update the Javadoc to the normal “Use X instead.” form in the same or next cleanup pass.

---

### 5) `forRemoval = true` (strict criteria)

You may set `forRemoval = true` only if **all** are true:

- Replacement exists and is not experimental.
- All internal call sites in this repo have migrated (or there’s a tracked issue for remaining ones).
- You intend to delete it in a planned cleanup sweep.

Template:

```java
/**
 * @deprecated Use {@link NewThing} instead. Scheduled for removal.
 */
@Deprecated(since = "2026-03-17", forRemoval = true)
```

---

### 6) Implementation rule for decompile refactors (avoid behavior drift)

When you deprecate because of a rename:

- Old member should be a **thin delegating wrapper** to the new member whenever possible.
- Avoid duplicated logic (prevents divergence / fixes landing in only one place).

---

### 7) Visibility rule (public API vs internal)

- **Public/protected/package-private**: must use full Javadoc form.
- **Private**: optional; prefer delete-or-rename directly. If kept temporarily, add a short comment even if you skip Javadoc.

### Repo-specific examples (fill in as we go)

- *(none yet — add first example when we deprecate the first real obfuscated API and its replacement is introduced)*

## Ongoing Notes

- Add ongoing notes here.