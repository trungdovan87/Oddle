package com.oddle.tdv.storage.db;

import com.oddle.tdv.db.sql.model.LogWeather;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LogWeatherRepository extends JpaRepository<LogWeather, Long>{
}
