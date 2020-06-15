package pl.keskadaniel.starwars.model;

import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.api.CharacterDto;
import pl.keskadaniel.starwars.model.api.HomeworldDto;
import pl.keskadaniel.starwars.model.api.StarshipDto;
import pl.keskadaniel.starwars.model.custom.CustomAllCharactersDto;
import pl.keskadaniel.starwars.model.custom.CustomCharacterDto;
import pl.keskadaniel.starwars.model.custom.CustomHomeworldDto;
import pl.keskadaniel.starwars.model.custom.CustomStarshipDto;

import java.util.List;
import java.util.stream.Collectors;

public class CharacterMapper {

    private static final Integer PAGINATOR = 10;

    public static CustomAllCharactersDto toCustomCharactersList(AllCharactersDto dto) {

        List<CustomCharacterDto> customCharacters = dto.getResults().stream()
                .map(characterDto -> toCustomCharacter(characterDto))
                .collect(Collectors.toList());

        return CustomAllCharactersDto.builder()
                .count(dto.getCount())
                .pages(calculatePages(dto.getCount()))
                .elements(customCharacters)
                .build();

    }

    public static CustomCharacterDto toCustomCharacter(CharacterDto dto) {

        return CustomCharacterDto.builder()
                .birthYear(dto.getBirthYear())
                .eyeColor(dto.getEyeColor())
                .gender(dto.getGender())
                .hairColor(dto.getHairColor())
                .height(dto.getHeight())
                .homeworld(setHomeworld(dto.getHomeworldDto()))
                .mass(dto.getMass())
                .name(dto.getName())
                .skinColor(dto.getSkinColor())
                .starships(setStarships(dto.getStarshipDtos()))
                .id(fetchId(dto.getUrl()))
                .build();

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
