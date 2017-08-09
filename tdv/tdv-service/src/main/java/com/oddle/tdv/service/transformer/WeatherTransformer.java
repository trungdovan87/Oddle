package com.oddle.tdv.service.transformer;

import com.oddle.tdv.communication.response.LogWeatherResponse;
import com.oddle.tdv.communication.response.WeatherResponse;
import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.LogWeather;
import com.oddle.tdv.db.sql.model.Weather;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class WeatherTransformer {
    public WeatherResponse convertToWeatherRes(Weather weather) {
        WeatherResponse result = new WeatherResponse();

        result.setCityId(weather.getCity().getId());
        result.setCityName(weather.getCity().getName());
        result.setCreateDate(weather.getCreateDate());
        result.setHumidity(weather.getHumidity());
        result.setPressure(weather.getPressure());
        result.setStatus(weather.getStatus());
        result.setTemperature(weather.getTemperature());
        result.setWindy(weather.getWindy());
        return result;
    }

    public Optional<WeatherResponse> convertToWeatherRes(Optional<Weather> optional) {
        if (optional.isPresent()) {
            Weather weather = optional.get();
            WeatherResponse response = convertToWeatherRes(weather);
            return Optional.of(response);
        } else {
            return Optional.empty();
        }
    }

    public WeatherResponse convertToWeatherRes(City city) {
        return convertToWeatherRes(city.getWeather());
    }

    public LogWeatherResponse convertLogWeatherRes(LogWeather log) {
        LogWeatherResponse result = new LogWeatherResponse();

        result.setId(log.getId());
        result.setCityId(log.getCity().getId());
        result.setCityName(log.getCity().getName());
        result.setCreateDate(log.getCreateDate());
        result.setHumidity(log.getHumidity());
        result.setPressure(log.getPressure());
        result.setStatus(log.getStatus());
        result.setTemperature(log.getTemperature());
        result.setWindy(log.getWindy());

        return result;
    }

    public List<LogWeatherResponse> convertToListLogWeatherRes(List<LogWeather> logs) {
        return logs.stream().map(this::convertLogWeatherRes).collect(Collectors.toList());
    }

    public List<WeatherResponse> convertToListWeatherRes(Page<City> page) {
        return page.stream().map(this::convertToWeatherRes).collect(Collectors.toList());
    }
}
