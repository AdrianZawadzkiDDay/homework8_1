package pl.bykowski.weather_api_and_hibernate.model.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String woeid;

    @OneToMany
    @JoinColumn(name = "cityId")
    private List<WeatherData> weatherHistoryList;

    public City() {
    }

    public City(String name, String woeid) {
        this.name = name;
        this.woeid = woeid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWoeid() {
        return woeid;
    }

    public void setWoeid(String woeid) {
        this.woeid = woeid;
    }

    public List<WeatherData> getWeatherDataList() {
        return weatherHistoryList;
    }

    public void setWeatherHistoryList(List<WeatherData> weatherHistoryList) {
        this.weatherHistoryList = weatherHistoryList;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", woeid='" + woeid + '\'' +
                ", weatherHistoryList=" + weatherHistoryList +
                '}';
    }

}
