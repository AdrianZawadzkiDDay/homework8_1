package pl.bykowski.weather_api_and_hibernate.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;
import pl.bykowski.weather_api_and_hibernate.model.entities.City;
import pl.bykowski.weather_api_and_hibernate.repository.CityRepository;
import pl.bykowski.weather_api_and_hibernate.service.WeatherService;


import java.util.List;

@Component
public class WeatherComponent {
    CityRepository cityRepository;
    WeatherService weatherService;

    @Autowired
    public WeatherComponent(CityRepository cityRepository, WeatherService weatherService) {
        this.cityRepository = cityRepository;
        this.weatherService = weatherService;
    }

    // saving weather data every hour
    @Schedules({
            @Scheduled(fixedDelay = 60*60*1000)
    })
    public void startWeather() throws InterruptedException {
        List<City> cityList = cityRepository.findAll();
        for (int i = 0; i < cityList.size() ; i++) {
            weatherService.saveWeather(cityList.get(i).getWoeid());
        }

    }


//    @EventListener(ApplicationReadyEvent.class)
//    public void addCity() {
//        City moscow = new City("Moscow","2122265" );
//        cityDbRepo.save(moscow);
//    }


    // https://www.metaweather.com/api/location/search/?query=Moscow
}
