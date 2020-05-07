package pl.bykowski.weather_api_and_hibernate.model.entities;



import pl.bykowski.weather_api_and_hibernate.model.weatherpojo.Weather;

import javax.persistence.*;

@Entity
@Table(name = "weather")
public class WeatherData {
//    private Weather weather;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long cityId;
    private String weatherStateName;
    private String created;
    private Double minTemp;
    private Double maxTemp;
    private Double theTemp;
    private Double windSpeed;
    private Double windDirection;
    private Double airPressure;
    private Integer humidity;

    public WeatherData() {
    }

    public WeatherData(Long cityId, String weatherStateName, String created, Double minTemp, Double maxTemp, Double theTemp, Double windSpeed, Double windDirection, Double airPressure, Integer humidity) {
        this.cityId = cityId;
        this.weatherStateName = weatherStateName;
        this.created = created;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.theTemp = theTemp;
        this.windSpeed = windSpeed;
        this.windDirection = windDirection;
        this.airPressure = airPressure;
        this.humidity = humidity;
    }

    public WeatherData(Weather weather, Long city){
        this.weatherStateName = weather.getConsolidatedWeather().get(0).getWeatherStateName();
        this.created = weather.getConsolidatedWeather().get(0).getCreated();
        this.minTemp = weather.getConsolidatedWeather().get(0).getMinTemp();
        this.maxTemp = weather.getConsolidatedWeather().get(0).getMaxTemp();
        this.theTemp = weather.getConsolidatedWeather().get(0).getTheTemp();
        this.windSpeed = weather.getConsolidatedWeather().get(0).getWindSpeed();
        this.windDirection = weather.getConsolidatedWeather().get(0).getWindDirection();
        this.airPressure = weather.getConsolidatedWeather().get(0).getAirPressure();
        this.humidity = weather.getConsolidatedWeather().get(0).getHumidity();
        this.cityId = city;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeatherStateName() {
        return weatherStateName;
    }

    public void setWeatherStateName(String weatherStateName) {
        this.weatherStateName = weatherStateName;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Double getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(Double minTemp) {
        this.minTemp = minTemp;
    }

    public Double getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(Double maxTemp) {
        this.maxTemp = maxTemp;
    }

    public Double getTheTemp() {
        return theTemp;
    }

    public void setTheTemp(Double theTemp) {
        this.theTemp = theTemp;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public Double getWindDirection() {
        return windDirection;
    }

    public void setWindDirection(Double windDirection) {
        this.windDirection = windDirection;
    }

    public Double getAirPressure() {
        return airPressure;
    }

    public void setAirPressure(Double airPressure) {
        this.airPressure = airPressure;
    }

    public Integer getHumidity() {
        return humidity;
    }

    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    //    public CityDB getCity() {
//        return city;
//    }
//
//    public void setCity(CityDB city) {
//        this.city = city;
//    }
}
