package com.oddle.tdv.storage.db;

import com.oddle.tdv.db.sql.model.LogWeather;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LogWeatherRepository extends JpaRepository<LogWeather, Long>{
    @Query("SELECT l FROM LogWeather l WHERE l.city.id = :cityId")
    Page<LogWeather> getByCityId(@Param("cityId") long cityId, Pageable pageable);
}
