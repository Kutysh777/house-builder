package com.housebuilder;

public class StoneHouseBuilder implements HouseBuilder {

    private static final int MAX_FLOORS = 4;

    private int floors;
    private int rooms;
    private double area;
    private RoofType roofType;
    private boolean hasGarage;
    private boolean hasGarden;
    private boolean hasPool;

    @Override
    public HouseBuilder setFloors(int floors) {
        this.floors = floors;
        return this;
    }

    @Override
    public HouseBuilder setRooms(int rooms) {
        this.rooms = rooms;
        return this;
    }

    @Override
    public HouseBuilder setArea(double area) {
        this.area = area;
        return this;
    }

    @Override
    public HouseBuilder setRoofType(RoofType roofType) {
        this.roofType = roofType;
        return this;
    }

    @Override
    public HouseBuilder withGarage() {
        this.hasGarage = true;
        return this;
    }

    @Override
    public HouseBuilder withGarden() {
        this.hasGarden = true;
        return this;
    }

    @Override
    public HouseBuilder withPool() {
        this.hasPool = true;
        return this;
    }

    @Override
    public House build() {
        if (floors < 1) {
            throw new IllegalStateException("Floors must be set before build()");
        }
        if (floors > MAX_FLOORS) {
            throw new IllegalStateException("Stone house can't have more than " + MAX_FLOORS + " floors");
        }
        if (rooms < 1) {
            throw new IllegalStateException("Rooms must be set before build()");
        }
        if (area <= 0) {
            throw new IllegalStateException("Area must be set before build()");
        }
        if (roofType == null) {
            throw new IllegalStateException("Roof type must be set before build()");
        }
        return new House(floors, rooms, area, WallMaterial.STONE, roofType, hasGarage, hasGarden, hasPool);
    }
}
