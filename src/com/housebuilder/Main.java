package com.housebuilder;

public class Main {

    public static void main(String[] args) {
        HouseDirector director = new HouseDirector();

        System.out.println("    Director recipes    ");

        House cottage = director.buildCottage(new WoodenHouseBuilder());
        System.out.println("Cottage: " + cottage);

        House familyHouse = director.buildFamilyHouse(new StoneHouseBuilder());
        System.out.println("Family house: " + familyHouse);

        House villa = director.buildLuxuryVilla(new StoneHouseBuilder());
        System.out.println("Luxury villa: " + villa);

        System.out.println();
        System.out.println("    Custom house, no director    ");

        House customHouse = new StoneHouseBuilder()
                .setFloors(1)
                .setRooms(4)
                .setArea(95)
                .setRoofType(RoofType.FLAT)
                .withGarage()
                .build();
        System.out.println("Custom house: " + customHouse);

        System.out.println();
        System.out.println("     Invalid input is rejected     ");

        try {
            director.buildLuxuryVilla(new WoodenHouseBuilder());
        } catch (IllegalStateException e) {
            System.out.println("Rejected: " + e.getMessage());
        }

        try {
            new StoneHouseBuilder().setFloors(2).build();
        } catch (IllegalStateException e) {
            System.out.println("Rejected: " + e.getMessage());
        }
    }
}
