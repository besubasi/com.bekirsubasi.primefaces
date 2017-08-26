package com.bekirsubasi.primefaces.view;


import com.bekirsubasi.primefaces.domain.City;
import com.bekirsubasi.primefaces.persistence.CityRepository;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Alex on 07/03/2015.
 */
@ManagedBean(name = "cityModel", eager = true)
@RequestScoped
public class CityModel {

    @ManagedProperty(value = "#{city}")
    private CityView city;


    @ManagedProperty(value = "#{cityRepository}")
    private CityRepository cityRepository;

    public CityView getCity() {
        return city;
    }

    public void setCity(CityView city) {
        this.city = city;
    }


    public CityRepository getCityRepository() {
        return cityRepository;
    }

    public void setCityRepository(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public String doCreateCity() {
        City created = new City();
        created.setCityId(this.city.getCityId());
        created.setName(this.city.getName());
        City newCity = this.cityRepository.save(created);

        FacesContext.getCurrentInstance().addMessage("errors",
            new FacesMessage(FacesMessage.SEVERITY_INFO, "City created",
                "The city " + created.getName() + " has been created with id=" + newCity.getCityId()));

        this.city.setName("");
        return "city.xhtml";
    }

    public void doFindCityById() {
        City found = cityRepository.findOne(this.city.getCityId());
        this.city.setCityId(found.getCityId());
        this.city.setName(found.getName());
    }

    public List<CityView> findAllCities() {
        List<CityView> cities = new ArrayList<CityView>();
        for(City entity : this.cityRepository.findAll()) {
            CityView view = new CityView();
            view.setCityId(entity.getCityId());
            view.setName(entity.getName());
            cities.add(view);
        }
        return cities;
    }

}
