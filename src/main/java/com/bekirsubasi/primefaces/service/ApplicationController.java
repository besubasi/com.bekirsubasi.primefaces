package com.bekirsubasi.primefaces.service;

import com.bekirsubasi.primefaces.domain.City;
import com.bekirsubasi.primefaces.domain.District;
import com.bekirsubasi.primefaces.persistence.CityRepository;
import com.bekirsubasi.primefaces.persistence.DistrictRepository;
import com.bekirsubasi.primefaces.persistence.StudentRepository;
import com.bekirsubasi.primefaces.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Alex on 18/03/2015.
 */

@RestController
public class ApplicationController {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private DistrictRepository districtRepository;

    @Autowired
    private StudentRepository studentRepository;

    @RequestMapping("")
    public @ResponseBody ModelAndView index() {
        return new ModelAndView("redirect:" + "/index.jsf");
    }


    @RequestMapping("/service/cities")
    public @ResponseBody Iterable<City> getAllCities() {
        return this.cityRepository.findAll();
    }
    
    @RequestMapping(value="/service/city/{cityId}", method=RequestMethod.GET)
    public @ResponseBody City getCityById(@PathVariable Long cityId) {
        return this.cityRepository.findOne(cityId);
    }


    @RequestMapping("/service/districts")
    public @ResponseBody Iterable<District> getAllDistricts() {
        return this.districtRepository.findAll();
    }

    @RequestMapping(value="/service/district/{districtId}", method=RequestMethod.GET)
    public @ResponseBody District getDistrictById(@PathVariable Long districtId) {
        return this.districtRepository.findOne(districtId);
    }

    @RequestMapping("/service/students")
    public @ResponseBody Iterable<Student> getAllStudents() {
        return this.studentRepository.findAll();
    }

    @RequestMapping(value="/service/student/{studentId}", method=RequestMethod.GET)
    public @ResponseBody Student getBookById(@PathVariable Long studentId) {
        return this.studentRepository.findOne(studentId);
    }

}
