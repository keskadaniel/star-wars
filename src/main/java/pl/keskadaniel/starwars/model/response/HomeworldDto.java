package pl.keskadaniel.starwars.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class HomeworldDto {

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
