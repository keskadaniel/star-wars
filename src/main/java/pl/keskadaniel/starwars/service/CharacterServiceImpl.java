package pl.keskadaniel.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import pl.keskadaniel.starwars.model.api.*;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final HttpClientService httpClient;

    @Value("${api.path.all-characters}")
    private String allCharactersPath;

    ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public AllCharactersDto findAll(String pageNumber) {

        if (pageNumber == null) {
//            return httpClient.doGet(allCharactersPath);
        }

        var paginatedCharactersPath = allCharactersPath + "?page=" + pageNumber;
        AllCharactersDto allCharacters = getAllCharacters(paginatedCharactersPath);
        if (allCharacters != null) {
            getHomeworld(allCharacters);
            getStarships(allCharacters);
        }


        return allCharacters;
    }

    private void getStarships(AllCharactersDto allCharacters) {
        allCharacters.getResults().stream()
                .filter(characterDto -> characterDto.getStarships() != null)
                .forEach(characterDto -> {

                    List<StarshipDto> starshipList = fetchStarships(characterDto);
                    characterDto.setStarshipsDto(starshipList);
//                    return characterDto;
                });
    }

    private List<StarshipDto> fetchStarships(CharacterDto characterDto) {
        List<StarshipDto> starshipList = new ArrayList<>();

        characterDto.getStarships().stream()
                .forEach(s -> {
                            String starshipInString = httpClient.doGet(s);
                            StarshipDto starshipDto = new StarshipDto();
                            try {
                                starshipDto = objectMapper.readValue(starshipInString, StarshipDto.class);
                                starshipList.add(starshipDto);
                            } catch (JsonProcessingException e) {

                            }

//
                        }
                );

        return starshipList;
    }

    private void getHomeworld(AllCharactersDto allCharacters) {
        allCharacters.getResults().stream()
                .filter(characterDto -> characterDto.getHomeworld() != null)
                .forEach(characterDto -> {
                    String homeworldInString = httpClient.doGet(characterDto.getHomeworld());
                    HomeworldDto homeworldDto = new HomeworldDto();
                    try {
                        homeworldDto = objectMapper.readValue(homeworldInString, HomeworldDto.class);
                    } catch (JsonProcessingException e) {
                        e.printStackTrace();
                    }
                    characterDto.setHomeworldDto(homeworldDto);
//                    return characterDto;
                });
    }

    private AllCharactersDto getAllCharacters(String charactersPath) {
        var charactersInString = httpClient.doGet(charactersPath);
        AllCharactersDto allCharactersDto = null;

        try {
            allCharactersDto = objectMapper.readValue(charactersInString, AllCharactersDto.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return allCharactersDto;
    }
}
