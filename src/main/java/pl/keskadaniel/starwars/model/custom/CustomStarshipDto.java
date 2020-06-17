package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import pl.keskadaniel.starwars.model.base.SWstarship;


public class CustomStarshipDto extends SWstarship {

    @Builder
    public CustomStarshipDto(String name, String model, String manufacturer, String costInCredits,
                             String length, String maxAtmosphericSpeed, String crew, String passengers,
                             String cargoCapacity, String consumables, String hyperdriveRating,
                             String mglt, String starshipClass) {
        super(name, model, manufacturer, costInCredits, length, maxAtmosphericSpeed, crew, passengers,
                cargoCapacity, consumables, hyperdriveRating, mglt, starshipClass);
    }
}
