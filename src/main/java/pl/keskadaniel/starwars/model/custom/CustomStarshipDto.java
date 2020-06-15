package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import lombok.Getter;
import pl.keskadaniel.starwars.model.base.SWstarship;


public class CustomStarshipDto extends SWstarship {

//    private String name;
//    private String model;
//    private String manufacturer;
//    private String costInCredits;
//    private String length;
//    private String maxAtmosphericSpeed;
//    private String crew;
//    private String passengers;
//    private String cargoCapacity;
//    private String consumables;
//    private String hyperdriveRating;
//    private String mglt;
//    private String starshipClass;

    @Builder
    public CustomStarshipDto(String name, String model, String manufacturer, String costInCredits,
                             String length, String maxAtmosphericSpeed, String crew, String passengers,
                             String cargoCapacity, String consumables, String hyperdriveRating,
                             String mglt, String starshipClass) {
        super(name, model, manufacturer, costInCredits, length, maxAtmosphericSpeed, crew, passengers,
                cargoCapacity, consumables, hyperdriveRating, mglt, starshipClass);
    }
}
