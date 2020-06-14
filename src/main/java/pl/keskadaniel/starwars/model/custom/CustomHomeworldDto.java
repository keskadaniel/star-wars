package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CustomHomeworldDto {

    private String name;
    private String rotationPeriod;
    private String orbitalPeriod;
    private String diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private String surfaceWater;
    private String population;

}
