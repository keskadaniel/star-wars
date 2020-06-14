package pl.keskadaniel.starwars.model;

import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.api.CharacterDto;
import pl.keskadaniel.starwars.model.custom.CustomAllCharactersDto;
import pl.keskadaniel.starwars.model.custom.CustomCharacterDto;
import pl.keskadaniel.starwars.model.custom.CustomHomeworldDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CharacterMapper {

    private static final Integer PAGINATOR = 10;

    public static CustomAllCharactersDto toCustomResponse(AllCharactersDto dto) {

        return CustomAllCharactersDto.builder()
                .count(dto.getCount())
                .pages(calculatePages(dto.getCount()))
                .elements(toCustomCharacter(dto.getResults()))
                .build();

    }

    private static List<CustomCharacterDto> toCustomCharacter(List<CharacterDto> dto) {

        return dto.stream()
                .map(swCharacter -> CustomCharacterDto.builder()
                        .birthYear(swCharacter.getBirth_year())
                        .eyeColor(swCharacter.getEye_color())
                        .gender(swCharacter.getGender())
                        .hairColor(swCharacter.getHair_color())
                        .height(swCharacter.getHeight())
                        .homeworld(CustomHomeworldDto.builder().build())
                        .mass(swCharacter.getMass())
                        .name(swCharacter.getName())
                        .skinColor(swCharacter.getSkin_color())
                        .starships(new ArrayList<>())
                        .id(fetchId(swCharacter.getUrl()))
                        .build())
                .collect(Collectors.toList());
    }

    private static Integer fetchId(String url) {

        var ulrArray = url.split("/");

        return Integer.valueOf(ulrArray[ulrArray.length - 1]);
    }

    private static Integer calculatePages(Integer totalSWcharacters) {

        Double pagesInDouble = Math.ceil((double) totalSWcharacters / PAGINATOR);

        return pagesInDouble.intValue();
    }


}
