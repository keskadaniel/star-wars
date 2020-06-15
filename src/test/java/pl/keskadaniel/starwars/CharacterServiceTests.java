package pl.keskadaniel.starwars;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.service.CharacterService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTests {

    @Mock
    CharacterService characterService;


    @Test
    public void shouldReturnAllCharactersDto() throws JsonProcessingException {
       // given
        final AllCharactersDto allCharactersDto = new AllCharactersDto();

        given(characterService.findAll("2")).willReturn(allCharactersDto);

        // when
        final AllCharactersDto result = characterService.findAll("2");

        // then
        assertThat(result).isEqualTo(allCharactersDto);

    }

}
