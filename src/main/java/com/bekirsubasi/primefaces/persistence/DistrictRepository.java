package com.bekirsubasi.primefaces.persistence;


import com.bekirsubasi.primefaces.domain.District;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 07/03/2015.
 */

public interface DistrictRepository extends JpaRepository<District, Long> {
}
