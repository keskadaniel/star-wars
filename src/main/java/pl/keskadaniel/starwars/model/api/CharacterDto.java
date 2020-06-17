package pl.keskadaniel.starwars.model.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pl.keskadaniel.starwars.model.base.SWcharacter;

import java.util.List;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class CharacterDto extends SWcharacter {

    @Override
    @JsonProperty("hair_color")
    public String getHairColor() {
        return super.getHairColor();
    }

    @Override
    @JsonProperty("skin_color")
    public String getSkinColor() {
        return super.getSkinColor();
    }

    @Override
    @JsonProperty("eye_color")
    public String getEyeColor() {
        return super.getEyeColor();
    }

    @Override
    @JsonProperty("birth_year")
    public String getBirthYear() {
        return super.getBirthYear();
    }

    private String homeworld;
    private List<String> films;
    private List<String> species;
    private List<String> vehicles;
    private List<String> starships;
    private String created;
    private String edited;
    private String url;

    private HomeworldDto homeworldDto;
    private List<StarshipDto> starshipDtos;

    @Builder
    public CharacterDto(Integer id, String name, String height, String mass, String hairColor,
                        String skinColor, String eyeColor, String birthYear, String gender,
                        String homeworld, List<String> films, List<String> species, List<String> vehicles,
                        List<String> starships, String created, String edited, String url,
                        HomeworldDto homeworldDto, List<StarshipDto> starshipDtos) {
        super(id, name, height, mass, hairColor, skinColor, eyeColor, birthYear, gender);
        this.homeworld = homeworld;
        this.films = films;
        this.species = species;
        this.vehicles = vehicles;
        this.starships = starships;
        this.created = created;
        this.edited = edited;
        this.url = url;
        this.homeworldDto = homeworldDto;
        this.starshipDtos = starshipDtos;
    }
}
