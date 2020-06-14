package pl.keskadaniel.starwars.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.keskadaniel.starwars.model.CharacterMapper;
import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.custom.CustomAllCharactersDto;
import pl.keskadaniel.starwars.service.CharacterService;

@RestController
@RequestMapping("characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;
    ObjectMapper objectMapper = new ObjectMapper();

    @GetMapping
    public CustomAllCharactersDto findAll(@RequestParam(name = "page", required = false) final String pageNumber) throws JsonProcessingException {

        AllCharactersDto all = objectMapper.readValue(characterService.findAll(pageNumber), AllCharactersDto.class);

        return CharacterMapper.toCustomResponse(all);
    }






}
