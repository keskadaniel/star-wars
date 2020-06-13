package pl.keskadaniel.starwars.model.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CustomSWcharacterDto {

    private Integer id;
    private String name;
    private String height;
    private String mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private HomeworldDto homeworld;
    private List<StarshipDto> starships;

}
