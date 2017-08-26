package com.bekirsubasi.primefaces.persistence;


import com.bekirsubasi.primefaces.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Alex on 07/03/2015.
 */

public interface StudentRepository extends JpaRepository<Student, Long> {
}
