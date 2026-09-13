package com.housebuilder;

public class House {

    private final int floors;
    private final int rooms;
    private final double area;
    private final WallMaterial material;
    private final RoofType roofType;
    private final boolean hasGarage;
    private final boolean hasGarden;
    private final boolean hasPool;

    public House(int floors, int rooms, double area, WallMaterial material, RoofType roofType,
                 boolean hasGarage, boolean hasGarden, boolean hasPool) {
        this.floors = floors;
        this.rooms = rooms;
        this.area = area;
        this.material = material;
        this.roofType = roofType;
        this.hasGarage = hasGarage;
        this.hasGarden = hasGarden;
        this.hasPool = hasPool;
    }

    public int getFloors() { return floors; }
    public int getRooms() { return rooms; }
    public double getArea() { return area; }
    public WallMaterial getMaterial() { return material; }
    public RoofType getRoofType() { return roofType; }
    public boolean hasGarage() { return hasGarage; }
    public boolean hasGarden() { return hasGarden; }
    public boolean hasPool() { return hasPool; }

    @Override
    public String toString() {
        return "House{material=" + material
                + ", floors=" + floors
                + ", rooms=" + rooms
                + ", area=" + area + "m2"
                + ", roof=" + roofType
                + ", garage=" + hasGarage
                + ", garden=" + hasGarden
                + ", pool=" + hasPool
                + "}";
    }
}
