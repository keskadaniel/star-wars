package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import lombok.Getter;
import pl.keskadaniel.starwars.model.base.SWcharacter;

import java.util.List;

@Getter
public class CustomCharacterDto extends SWcharacter {

    private CustomHomeworldDto homeworld;
    private List<CustomStarshipDto> starships;

    @Builder
    public CustomCharacterDto(Integer id, String name, String height, String mass, String hairColor,
                              String skinColor, String eyeColor, String birthYear, String gender,
                              CustomHomeworldDto homeworld, List<CustomStarshipDto> starships) {
        super(id, name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender);
        this.homeworld = homeworld;
        this.starships = starships;
    }
}
