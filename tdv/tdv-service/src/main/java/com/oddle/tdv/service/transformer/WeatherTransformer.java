package com.oddle.tdv.service.transformer;

import com.oddle.tdv.communication.response.WeatherResponse;
import com.oddle.tdv.db.sql.model.Weather;

import java.util.Optional;

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
}
