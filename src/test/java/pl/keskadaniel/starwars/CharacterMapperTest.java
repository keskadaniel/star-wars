package pl.keskadaniel.starwars;

import org.junit.jupiter.api.Test;
import pl.keskadaniel.starwars.model.CharacterMapper;
import pl.keskadaniel.starwars.model.custom.CustomAllCharactersDto;
import pl.keskadaniel.starwars.model.custom.CustomCharacterDto;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class CharacterMapperTest {


    @Test
    public void shouldFetchIdFromCharacterDtoUrl(){
        //given
        var characterDto = PrepareData.ofCharacterDto();

        //when
        CustomCharacterDto customCharacterDto = CharacterMapper.toCustomCharacter(characterDto);
        var result = customCharacterDto.getId();

        //then
        assertThat(result).isEqualTo(23);
        assertThat(result).isNotEqualTo(33);
        assertThat(result).isNotZero();
        assertThat(result).isNotNull();

    }

    @Test
    public void shouldCalculatePagesFromTotalCount(){
        //given
        var givenAllCharacters = PrepareData.ofAllCharactersDto();
        givenAllCharacters.setCount(54);

        //when
        var customAllCharactersDto = CharacterMapper.toCustomCharactersList(givenAllCharacters);
        var result = customAllCharactersDto.getPages();

        //then
        assertThat(result).isEqualTo(6);
        assertThat(result).isNotEqualTo(5);
        assertThat(result).isNotEqualTo(7);
        assertThat(result).isNotZero();
        assertThat(result).isNotNull();

    }

    @Test
    public void shouldMapAllCharactersDtoToCustomCharactersList(){
        //given
        var givenAllCharacters = PrepareData.ofAllCharactersDto();

        //when
        var result = CharacterMapper.toCustomCharactersList(givenAllCharacters);

        //then
        assertThat(result).isInstanceOf(CustomAllCharactersDto.class);
        assertThat(result).isNotNull();
        assertThat(result.getCount()).isEqualTo(givenAllCharacters.getCount());
        assertThat(result.getElements().get(0).getName()).isEqualTo(givenAllCharacters.getResults().get(0).getName());
    }

    @Test
    public void shouldMapCharactersDtoToCustomCharacterDto(){
        //given
        var givenCharacter = PrepareData.ofCharacterDto();

        //when
        var result = CharacterMapper.toCustomCharacter(givenCharacter);

        //then
        assertThat(result).isInstanceOf(CustomCharacterDto.class);
        assertThat(result).isNotNull();
        assertThat(result.getHomeworld().getName()).isEqualTo(givenCharacter.getHomeworldDto().getName());
        assertThat(result.getStarships().size()).isEqualTo(givenCharacter.getStarshipDtos().size());
    }



}
