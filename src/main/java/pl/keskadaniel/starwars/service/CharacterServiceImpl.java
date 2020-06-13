package pl.keskadaniel.starwars.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final HttpClientService httpClient;

    @Override
    public String findAll() {
        return httpClient.doGet("https://swapi.dev/api/people/");
    }
}
