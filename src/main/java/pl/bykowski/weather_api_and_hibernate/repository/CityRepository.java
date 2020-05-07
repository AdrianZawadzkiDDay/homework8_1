package pl.bykowski.weather_api_and_hibernate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.bykowski.weather_api_and_hibernate.model.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    City findCityByWoeid(String woe);
}
