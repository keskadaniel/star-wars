package pl.keskadaniel.starwars.model.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
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

    @Builder
    public HomeworldDto(String name, String rotationPeriod, String orbitalPeriod, String diameter,
                        String climate, String gravity, String terrain, String surfaceWater,
                        String population, List<String> residents, List<String> films,
                        String created, String edited, String url) {
        super(name, rotationPeriod, orbitalPeriod, diameter, climate, gravity, terrain, surfaceWater, population);
        this.residents = residents;
        this.films = films;
        this.created = created;
        this.edited = edited;
        this.url = url;
    }
}
