package com.oddle.tdv.storage.db;

import com.oddle.tdv.db.sql.model.City;
import com.oddle.tdv.db.sql.model.OddUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c FROM City c WHERE c.name LIKE ?1")
    Optional<City> findByName(String name);

    @Query("SELECT c FROM City  c WHERE c.name LIKE concat(:name, '%')")
    Page<City> searchByName(@Param("name") String name, Pageable pageable);
}
