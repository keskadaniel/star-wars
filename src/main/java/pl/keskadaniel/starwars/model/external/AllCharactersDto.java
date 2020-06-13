package pl.keskadaniel.starwars.model.external;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class AllCharactersDto {

    private Integer count;
    private String next;
    private String previous;
    private List<StarWarsCharacterDto> results;
}
