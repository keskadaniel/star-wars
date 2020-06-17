package pl.keskadaniel.starwars.model.api;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllCharactersDto {

    private Integer count;
    private String next;
    private String previous;
    private List<CharacterDto> results;
}
