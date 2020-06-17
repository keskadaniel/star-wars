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
        final AllCharactersDto givenAllCharactersDto = PrepareData.ofAllCharactersDto();
        final AllCharactersDto givenSecondAllCharactersDto = PrepareData.ofAllCharactersDto();

        given(characterService.findAll("2")).willReturn(givenAllCharactersDto);
        given(characterService.findAll("8")).willReturn(givenSecondAllCharactersDto);

        // when
        final AllCharactersDto result = characterService.findAll("2");
        final AllCharactersDto resultSecond = characterService.findAll("8");

        // then
        assertThat(result).isEqualTo(givenAllCharactersDto);
        assertThat(result).isInstanceOf(AllCharactersDto.class);
        assertThat(result).isNotNull();

        assertThat(result).isEqualTo(givenAllCharactersDto);
        assertThat(result).isNotNull();

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

    @Test
    public void shouldNotReturnCharacterDtoWhenNoIdGiven() {
        // given
        given(characterService.findById(null)).willReturn(null);

        // when
        final CharacterDto result = characterService.findById(null);

        // then
        assertThat(result).isNull();

    }

}
