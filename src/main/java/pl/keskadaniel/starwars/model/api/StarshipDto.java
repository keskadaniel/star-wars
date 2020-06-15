package pl.keskadaniel.starwars.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.keskadaniel.starwars.model.base.SWstarship;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class StarshipDto extends SWstarship {

    @Override
    @JsonProperty("cost_in_credits")
    public String getCostInCredits() {
        return super.getCostInCredits();
    }

    @Override
    @JsonProperty("max_atmosphering_speed")
    public String getMaxAtmosphericSpeed() {
        return super.getMaxAtmosphericSpeed();
    }

    @Override
    @JsonProperty("cargo_capacity")
    public String getCargoCapacity() {
        return super.getCargoCapacity();
    }

    @Override
    @JsonProperty("hyperdrive_rating")
    public String getHyperdriveRating() {
        return super.getHyperdriveRating();
    }

    @Override
    @JsonProperty("MGLT")
    public String getMglt() {
        return super.getMglt();
    }

    @Override
    @JsonProperty("starship_class")
    public String getStarshipClass() {
        return super.getStarshipClass();
    }

    private List<String> pilots;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

}
