package com.housebuilder;

public class HouseDirector {

    public House buildCottage(HouseBuilder builder) {
        return builder.setFloors(1)
                .setRooms(3)
                .setArea(60)
                .setRoofType(RoofType.GABLE)
                .withGarden()
                .build();
    }

    public House buildFamilyHouse(HouseBuilder builder) {
        return builder.setFloors(2)
                .setRooms(6)
                .setArea(140)
                .setRoofType(RoofType.HIP)
                .withGarage()
                .withGarden()
                .build();
    }

    public House buildLuxuryVilla(HouseBuilder builder) {
        return builder.setFloors(3)
                .setRooms(8)
                .setArea(250)
                .setRoofType(RoofType.HIP)
                .withGarage()
                .withGarden()
                .withPool()
                .build();
    }
}
