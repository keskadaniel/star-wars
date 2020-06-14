package pl.keskadaniel.starwars.model.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StarWarsUniverseDto {

    private AllCharactersDto charactersDto;
    private HomeworldDto homeworldDto;
    private StarshipDto starshipDto;

}
