package pl.keskadaniel.starwars.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.keskadaniel.starwars.service.CharacterService;

@RestController
@RequestMapping("characters")
@RequiredArgsConstructor
public class CharacterController {

    private final CharacterService characterService;

    @GetMapping
    public String findAll(@RequestParam(name = "page", required = false) final String pageNumber){
        return characterService.findAll(pageNumber);
    }






}
