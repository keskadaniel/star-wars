package pl.keskadaniel.starwars.model.response;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class CustomCharactersDto {

    private Integer count;
    private Integer pages;
    private List<CustomSWcharacterDto> elements;

}
