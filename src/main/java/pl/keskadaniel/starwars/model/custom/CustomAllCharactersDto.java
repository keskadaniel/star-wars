package pl.keskadaniel.starwars.model.custom;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CustomAllCharactersDto {

    private Integer count;
    private Integer pages;
    private List<CustomCharacterDto> elements;

}
