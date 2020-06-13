package pl.keskadaniel.starwars.model.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class StarshipDto {

    private String name;
    private String model;
    private String manufacturer;
    private String costInCredits;
    private String length;
    private String maxAtmosphericSpeed;
    private String crew;
    private String passengers;
    private String cargoCapacity;
    private String consumables;
    private String hyperdriveRating;
    private String mglt;
    private String starshipClass;

}
