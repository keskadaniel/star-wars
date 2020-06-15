package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import pl.keskadaniel.starwars.model.base.SWhomeworld;


public class CustomHomeworldDto extends SWhomeworld {

    @Builder
    public CustomHomeworldDto(String name, String rotationPeriod, String orbitalPeriod,
                              String diameter, String climate, String gravity, String terrain,
                              String surfaceWater, String population) {
        super(name, rotationPeriod, orbitalPeriod, diameter, climate, gravity, terrain,
                surfaceWater, population);
    }
}
