package com.housebuilder;

public interface HouseBuilder {

    HouseBuilder setFloors(int floors);

    HouseBuilder setRooms(int rooms);

    HouseBuilder setArea(double area);

    HouseBuilder setRoofType(RoofType roofType);

    HouseBuilder withGarage();

    HouseBuilder withGarden();

    HouseBuilder withPool();

    House build();
}
