package pl.keskadaniel.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.keskadaniel.starwars.model.api.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final HttpClientService httpClient;
    private final ObjectMapper objectMapper;

    @Value("${api.path.all-characters}")
    private String allCharactersPath;

    @Override
    public AllCharactersDto findAll(String pageNumber) {

        if (pageNumber == null) {
            AllCharactersDto allCharacters = getCharacters(allCharactersPath);
            return allCharacters;
        }

        var paginatedCharactersPath = allCharactersPath + "?page=" + pageNumber;
        AllCharactersDto allCharacters = getCharacters(paginatedCharactersPath);

        return allCharacters;
    }

    @Override
    public CharacterDto findById(final String id) {

        var characterPath = allCharactersPath + id + "/";
        CharacterDto characterDto = getCharacter(characterPath);

        if (characterDto != null) {
            characterDto.setHomeworldDto(fetchHomeworldForCharacter(characterDto));
            characterDto.setStarshipDtos(fetchStarshipsForCharacter(characterDto));
        }

        return characterDto;
    }

    private AllCharactersDto getCharacters(String allCharactersPath) {
        AllCharactersDto allCharacters = getAllCharacters(allCharactersPath);

        if (allCharacters == null) {
            log.error("Could not get Characters");
            return new AllCharactersDto();
        }

        getHomeworldForAll(allCharacters);
        getStarshipsForAll(allCharacters);

        return allCharacters;
    }

    private void getStarshipsForAll(AllCharactersDto allCharacters) {
        allCharacters.getResults().stream()
                .filter(characterDto -> characterDto.getStarships() != null)
                .forEach(characterDto -> {
                    List<StarshipDto> starshipList = fetchStarshipsForCharacter(characterDto);
                    characterDto.setStarshipDtos(starshipList);
                });
    }

    private List<StarshipDto> fetchStarshipsForCharacter(CharacterDto characterDto) {
        List<StarshipDto> starshipList = new ArrayList<>();

        characterDto.getStarships().stream()
                .forEach(s -> {
                            String starshipInString = httpClient.doGet(s);
                            StarshipDto starshipDto = new StarshipDto();
                            try {
                                starshipDto = objectMapper.readValue(starshipInString, StarshipDto.class);
                                starshipList.add(starshipDto);
                            } catch (JsonProcessingException e) {
                                log.error("Could not parse StarshipDto from String: ", e.getCause());
                            }
                        }
                );

        return starshipList;
    }

    private void getHomeworldForAll(AllCharactersDto allCharacters) {
        allCharacters.getResults().stream()
                .filter(characterDto -> characterDto.getHomeworld() != null)
                .forEach(characterDto -> {
                    HomeworldDto homeworldDto = fetchHomeworldForCharacter(characterDto);
                    characterDto.setHomeworldDto(homeworldDto);
                });
    }

    private HomeworldDto fetchHomeworldForCharacter(CharacterDto characterDto) {
        String homeworldInString = httpClient.doGet(characterDto.getHomeworld());
        HomeworldDto homeworldDto = new HomeworldDto();
        try {
            homeworldDto = objectMapper.readValue(homeworldInString, HomeworldDto.class);
        } catch (JsonProcessingException e) {
            log.error("Could not parse HomeworldDto from String: ", e.getCause());
        }
        return homeworldDto;
    }

    private AllCharactersDto getAllCharacters(String charactersPath) {
        var charactersInString = httpClient.doGet(charactersPath);
        AllCharactersDto allCharactersDto = null;

        try {
            allCharactersDto = objectMapper.readValue(charactersInString, AllCharactersDto.class);
        } catch (JsonProcessingException e) {
            log.error("Could not parse AllCharactersDto from String: ", e.getCause());
        }
        return allCharactersDto;
    }

    private CharacterDto getCharacter(String characterPath) {
        var charactersInString = httpClient.doGet(characterPath);
        CharacterDto characterDto = null;

        try {
            characterDto = objectMapper.readValue(charactersInString, CharacterDto.class);
        } catch (JsonProcessingException e) {
            log.error("Could not parse CharacterDto from String: ", e.getCause());
        }
        return characterDto;
    }
}
