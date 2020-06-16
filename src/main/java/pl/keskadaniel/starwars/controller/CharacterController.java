package pl.keskadaniel.starwars.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import pl.keskadaniel.starwars.model.CharacterMapper;
import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.api.CharacterDto;
import pl.keskadaniel.starwars.model.custom.CustomAllCharactersDto;
import pl.keskadaniel.starwars.model.custom.CustomCharacterDto;
import pl.keskadaniel.starwars.service.CharacterService;

@Slf4j
@RestController
@RequestMapping("characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public CustomAllCharactersDto findAll(@RequestParam(name = "page", required = false) final String pageNumber) throws JsonProcessingException {

        AllCharactersDto all = characterService.findAll(pageNumber);

        if(StringUtils.isEmpty(all.getResults())){
            log.warn("There are no characters on given page: {}", pageNumber);
            return CustomAllCharactersDto.builder()
                    .build();
        }

        return CharacterMapper.toCustomCharactersList(all);
    }

    @GetMapping("/{id}")
    public CustomCharacterDto findById(@PathVariable final String id) {

        CharacterDto characterDto = characterService.findById(id);

        if(StringUtils.isEmpty(characterDto.getName())){
            log.warn("There is no character with id: {}", id);
            return CustomCharacterDto.builder().build();
        }

        return CharacterMapper.toCustomCharacter(characterDto);
    }


}
