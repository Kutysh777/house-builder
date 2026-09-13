# House Builder — Assignment 1 (Builder Pattern)

## What the product is

The product is `House`. I picked a house because the lecture itself gives
this exact example for the Builder pattern: creating different
representations of the same product, like a stone house and a wooden house.
So there are two builders — `StoneHouseBuilder` and `WoodenHouseBuilder` —
and the difference between them is not just cosmetic: a wood frame can't
carry as many floors as stone, so each builder enforces its own floor limit.

## Components

- `House` — Product. Just holds the finished data, nothing else.
- `HouseBuilder` — Builder interface, declares the construction steps
  (setFloors, setRooms, setArea, setRoofType, withGarage, withGarden,
  withPool, build).
- `StoneHouseBuilder`, `WoodenHouseBuilder` — Concrete builders. Each fixes
  the wall material and its own floor limit.
- `HouseDirector` — Director. Has 3 ready-made recipes: `buildCottage`,
  `buildFamilyHouse`, `buildLuxuryVilla`.
- `Main` — Client. Uses the director, builds one house directly without a
  director, and shows what happens when the input is invalid.

Method chaining is used everywhere: every setter returns `this`, so a house
is built as one readable chain, e.g.

```java
House customHouse = new StoneHouseBuilder()
        .setFloors(1)
        .setRooms(4)
        .setArea(95)
        .setRoofType(RoofType.FLAT)
        .withGarage()
        .build();
```

## Clean Code principles applied (Section 3)

**1. Meaningful, intention-revealing names**
`setFloors(int floors)`, `withGarage()`, `buildLuxuryVilla()` — a chain like
`.setFloors(2).setRooms(6).withGarage()` can be read without checking any
method signature. This also avoids boolean flag arguments: instead of
`setGarage(boolean hasGarage)` (call site `setGarage(true)` doesn't say what
`true` means), I used a no-argument `withGarage()` — calling it already
means "yes, add a garage".

**2. Small methods, each doing one thing**
Every setter in the builders sets exactly one field and returns `this`.
Nothing else happens inside them.

**3. Consistent formatting and small, focused classes**
`House` only stores data. `HouseBuilder` only declares steps. Each concrete
builder only knows how to build one material. `HouseDirector` only holds
recipes. No class does more than one job.

**4. Validated construction**
Before (what I didn't do): `build()` would just return `new House(...)` even
if `floors == 0` or the roof type was never set — a broken house gets
created silently.
After (what the code does):
```java
if (floors > MAX_FLOORS) {
    throw new IllegalStateException("Wooden house can't have more than " + MAX_FLOORS + " floors");
}
```
`build()` checks every required field and each material's own floor limit,
and throws `IllegalStateException` with a clear message instead. `Main`
shows two rejected builds: a 3-floor wooden villa, and a house missing its
rooms/area/roof.

**5. No magic numbers/strings**
Before: `setMaterial("stone")` — a typo like `"ston"` would compile fine and
only break later.
After: `WallMaterial` and `RoofType` are enums, and each builder's floor
limit is a named constant, `MAX_FLOORS`, not a bare number hidden inside an
`if`.

## How to run

No external dependencies, plain JDK:

```bash
javac -d out src/com/housebuilder/*.java
java -cp out com.housebuilder.Main
```
