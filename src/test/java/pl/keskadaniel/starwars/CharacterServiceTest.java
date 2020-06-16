package pl.keskadaniel.starwars;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.keskadaniel.starwars.model.api.AllCharactersDto;
import pl.keskadaniel.starwars.model.api.CharacterDto;
import pl.keskadaniel.starwars.service.CharacterService;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class CharacterServiceTest {

    @Mock
    CharacterService characterService;


    @Test
    public void shouldReturnAllCharactersDto() throws JsonProcessingException {
       // given
        final AllCharactersDto allCharactersDto = PrepareData.ofAllCharactersDto();

        given(characterService.findAll("2")).willReturn(allCharactersDto);

        // when
        final AllCharactersDto result = characterService.findAll("2");

        // then
        assertThat(result).isEqualTo(allCharactersDto);

    }


    @Test
    public void shouldReturnCharacterDto() {
        // given
        final CharacterDto character = PrepareData.ofCharacterDto();

        given(characterService.findById("1")).willReturn(character);

        // when
        final CharacterDto result = characterService.findById("1");

        // then
        assertThat(result).isEqualTo(character);

    }

    @Test
    public void shouldNotReturnCharacterDto() {
        // given
        final CharacterDto givenCharacter = PrepareData.ofCharacterDto();

        // when
        final CharacterDto result = characterService.findById("2");

        // then
        assertThat(result).isNotEqualTo(givenCharacter);

    }

}
