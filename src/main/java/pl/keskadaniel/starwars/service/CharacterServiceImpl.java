package pl.keskadaniel.starwars.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final HttpClientService httpClient;

    @Value("${api.path.all-characters}")
    private String allCharactersPath;

    @Override
    public String findAll(String pageNumber) {

        if(pageNumber == null){
            return httpClient.doGet(allCharactersPath);
        }

        var paginatedCharactersPath = allCharactersPath + "?page=" + pageNumber;

        return httpClient.doGet(paginatedCharactersPath);
    }
}
