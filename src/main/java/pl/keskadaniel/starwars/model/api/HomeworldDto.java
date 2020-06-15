package pl.keskadaniel.starwars.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import pl.keskadaniel.starwars.model.base.SWhomeworld;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class HomeworldDto extends SWhomeworld {

    @Override
    @JsonProperty("rotation_period")
    public String getRotationPeriod() {
        return super.getRotationPeriod();
    }

    @Override
    @JsonProperty("orbital_period")
    public String getOrbitalPeriod() {
        return super.getOrbitalPeriod();
    }

    @Override
    @JsonProperty("surface_water")
    public String getSurfaceWater() {
        return super.getSurfaceWater();
    }

    private List<String> residents;
    private List<String> films;
    private String created;
    private String edited;
    private String url;

}
