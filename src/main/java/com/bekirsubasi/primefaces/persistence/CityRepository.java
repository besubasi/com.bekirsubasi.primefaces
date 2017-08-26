package com.bekirsubasi.primefaces.persistence;


import com.bekirsubasi.primefaces.domain.City;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 07/03/2015.
 */

public interface CityRepository extends JpaRepository<City, Long> {
}
