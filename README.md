# House Builder — Assignment 1

## Product

The product is `House`.

A house can have different configurations. For example, it can be made from stone or wood.
There are two builders:
- `StoneHouseBuilder`
- `WoodenHouseBuilder`

Each builder has its own floor limit.

## Components

- `House` — Product
- `HouseBuilder` — Builder
- `StoneHouseBuilder`, `WoodenHouseBuilder` — Concrete Builders
- `HouseDirector` — Director
- `Main` — Client

The Builder Pattern helps to create a house step by step.
Method chaining is used, so the code is easier to read.

The `HouseDirector` has several ready configurations:
- Cottage
- Family House
- Luxury Villa

It is also possible to create a house directly with a builder without using the Director.

## Clean Code

### 1. Meaningful names
Names like `setFloors()`, `withGarage()` and `buildLuxuryVilla()` clearly show what the methods do.

### 2. Small methods
Each setter changes one field and returns `this`.

### 3. Single responsibility
Each class has one main job.

### 4. Validation
The `build()` method checks the house data before creating it.

### 5. No magic numbers or strings
Enums are used instead of repeated string values.

## How to Run

```bash
javac -d out src/com/housebuilder/*.java
java -cp out com.housebuilder.Main