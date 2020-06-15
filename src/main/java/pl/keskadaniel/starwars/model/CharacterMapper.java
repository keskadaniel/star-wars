package pl.keskadaniel.starwars.model;

import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.api.CharacterDto;
import pl.keskadaniel.starwars.model.api.HomeworldDto;
import pl.keskadaniel.starwars.model.api.StarshipDto;
import pl.keskadaniel.starwars.model.custom.CustomAllCharactersDto;
import pl.keskadaniel.starwars.model.custom.CustomCharacterDto;
import pl.keskadaniel.starwars.model.custom.CustomHomeworldDto;
import pl.keskadaniel.starwars.model.custom.CustomStarshipDto;

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
                .map(swCharacter ->
                        CustomCharacterDto.builder()
                                .birthYear(swCharacter.getBirthYear())
                                .eyeColor(swCharacter.getEyeColor())
                                .gender(swCharacter.getGender())
                                .hairColor(swCharacter.getHairColor())
                                .height(swCharacter.getHeight())
                                .homeworld(setHomeworld(swCharacter.getHomeworldDto()))
                                .mass(swCharacter.getMass())
                                .name(swCharacter.getName())
                                .skinColor(swCharacter.getSkinColor())
                                .starships(setStarships(swCharacter.getStarshipsDto()))
                                .id(fetchId(swCharacter.getUrl()))
                                .build())
                .collect(Collectors.toList());
    }

    private static List<CustomStarshipDto> setStarships(List<StarshipDto> starshipsDto) {
        return starshipsDto.stream()
                .map(starship -> CustomStarshipDto.builder()
                        .cargoCapacity(starship.getCargoCapacity())
                        .consumables(starship.getConsumables())
                        .costInCredits(starship.getCostInCredits())
                        .crew(starship.getCrew())
                        .hyperdriveRating(starship.getHyperdriveRating())
                        .length(starship.getLength())
                        .manufacturer(starship.getManufacturer())
                        .maxAtmosphericSpeed(starship.getMaxAtmosphericSpeed())
                        .mglt(starship.getMglt())
                        .model(starship.getModel())
                        .name(starship.getName())
                        .passengers(starship.getPassengers())
                        .starshipClass(starship.getStarshipClass())
                        .build()
                ).collect(Collectors.toList());
    }

    private static CustomHomeworldDto setHomeworld(HomeworldDto dto) {

        return CustomHomeworldDto.builder()
                .climate(dto.getClimate())
                .diameter(dto.getDiameter())
                .gravity(dto.getGravity())
                .name(dto.getName())
                .orbitalPeriod(dto.getOrbitalPeriod())
                .population(dto.getPopulation())
                .rotationPeriod(dto.getRotationPeriod())
                .surfaceWater(dto.getSurfaceWater())
                .terrain(dto.getTerrain())
                .build();
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
