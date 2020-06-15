package pl.keskadaniel.starwars.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pl.keskadaniel.starwars.model.api.AllCharactersDto;

public interface CharacterService {

    AllCharactersDto findAll(String pageNumber) throws JsonProcessingException;


}
