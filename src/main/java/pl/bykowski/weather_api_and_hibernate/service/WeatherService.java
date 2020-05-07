package pl.bykowski.weather_api_and_hibernate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.bykowski.weather_api_and_hibernate.model.entities.WeatherData;
import pl.bykowski.weather_api_and_hibernate.model.weatherpojo.ConsolidatedWeather;
import pl.bykowski.weather_api_and_hibernate.model.weatherpojo.Weather;
import pl.bykowski.weather_api_and_hibernate.repository.CityRepository;
import pl.bykowski.weather_api_and_hibernate.repository.WeatherRepository;


@Service
public class WeatherService {

    Weather weather;
    ConsolidatedWeather consolidatedWeather;
    WeatherRepository weatherRepository;
    CityRepository cityRepository;

    @Autowired
    public WeatherService(WeatherRepository weatherRepository, CityRepository cityRepository) {
        this.weatherRepository = weatherRepository;
        this.cityRepository = cityRepository;
        weather = new Weather();
        consolidatedWeather = new ConsolidatedWeather();
    }

    public void saveWeather(String city) {
        Weather weathernew = new Weather();
        HttpEntity httpEntity = new HttpEntity(weathernew);
        RestTemplate restTemplate = new RestTemplate();

        String urlCity= "https://www.metaweather.com/api/location/" + city;
        System.out.println(urlCity);
        ResponseEntity<Weather> weatherResponseEntity = restTemplate.exchange(
                String.format(urlCity),
                HttpMethod.GET,
                httpEntity,
                Weather.class);
        this.weather = weatherResponseEntity.getBody();

        weatherRepository.save(new WeatherData(weather, cityRepository.findCityByWoeid(city).getId()));
    }
}
