package pl.keskadaniel.starwars;

import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.api.CharacterDto;
import pl.keskadaniel.starwars.model.api.HomeworldDto;
import pl.keskadaniel.starwars.model.api.StarshipDto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PrepareData {


    public static AllCharactersDto ofAllCharactersDto() {

        var dto = new AllCharactersDto();
        dto.setCount(82);
        dto.setNext("www.somelink.pl/2/");
        dto.setPrevious("www.somelink.pl/");
        dto.setResults(ofListCharacterDto());

        return dto;
    }

    public static List<CharacterDto> ofListCharacterDto() {
        List<CharacterDto> listOfCharacters = new ArrayList<>();
        listOfCharacters.add(ofCharacterDto());

        return listOfCharacters;
    }

    public static CharacterDto ofCharacterDto() {

        return CharacterDto.builder()
                .starshipDtos(ofListStarshipDto())
                .birthYear("2345")
                .created("43.22")
                .edited("21.21")
                .eyeColor("blue")
                .films(new ArrayList<String>(Arrays.asList("Star wars", "star wars 2")))
                .gender("male")
                .hairColor("brown")
                .height("23")
                .homeworld("linktohomeworld.pl")
                .homeworldDto(ofHomeworldDto())
                .id(0)
                .mass("43")
                .name("obi")
                .skinColor("green")
                .species(new ArrayList<>())
                .starships(new ArrayList<>())
                .url("www.url.pl/23/")
                .vehicles(new ArrayList<>())
                .build();
    }

    public static List<StarshipDto> ofListStarshipDto(){
        List<StarshipDto> starshipDtoList = new ArrayList<>();
        starshipDtoList.add(ofStarshipDto());

        return starshipDtoList;

    }

    public static StarshipDto ofStarshipDto() {

        return StarshipDto.builder()
                .cargoCapacity("capacity")
                .consumables("consu")
                .costInCredits("321")
                .created("32.42")
                .crew("2")
                .edited("32.32")
                .films(new ArrayList<String>(Arrays.asList("Star wars", "star wars 2")))
                .hyperdriveRating("32")
                .length("321312")
                .manufacturer("cos")
                .maxAtmosphericSpeed("2324")
                .mglt("fdsdas")
                .model("c-09")
                .name("rocky")
                .passengers("4")
                .pilots(new ArrayList<String>(Arrays.asList("Spock", "Chupacabra")))
                .starshipClass("high")
                .url("someulr.pl/32")
                .build();
    }

    public static HomeworldDto ofHomeworldDto() {

        return HomeworldDto.builder()
                .climate("mid")
                .diameter("11")
                .created("32.32")
                .edited("40.40")
                .films(new ArrayList<>())
                .gravity("32")
                .name("uranos")
                .orbitalPeriod("3")
                .population("0")
                .residents(new ArrayList<>())
                .rotationPeriod("5")
                .surfaceWater("wet")
                .terrain("brown")
                .url("ulr.test.pl")
                .build();

    }

}
