package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CustomCharacterDto {

    private Integer id;
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private CustomHomeworldDto homeworld;
    private List<CustomStarshipDto> starships;

}
