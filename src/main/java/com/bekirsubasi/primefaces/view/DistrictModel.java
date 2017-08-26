package com.bekirsubasi.primefaces.view;


import com.bekirsubasi.primefaces.domain.City;
import com.bekirsubasi.primefaces.domain.District;
import com.bekirsubasi.primefaces.persistence.CityRepository;
import com.bekirsubasi.primefaces.persistence.DistrictRepository;

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
@ManagedBean(name = "districtModel", eager = true)
@RequestScoped
public class DistrictModel {

    @ManagedProperty(value = "#{district}")
    private DistrictView district;


    @ManagedProperty(value = "#{districtRepository}")
    private DistrictRepository districtRepository;


    public String doCreateDistrict() {
        District created = new District();
        created.setDistrictId(this.district.getDistrictId());
        created.setCityId(this.district.getCityId());
        created.setName(this.district.getName());

        District newDistrict = this.districtRepository.save(created);

        FacesContext.getCurrentInstance().addMessage("errors",
            new FacesMessage(FacesMessage.SEVERITY_INFO, "District created",
                "The district " + created.getName() + " has been created with id=" + newDistrict.getDistrictId()));

        this.district.setName("");
        this.district.setCityId(null);
        return "district.xhtml";
    }

    public void doFindDistrictById() {
        District found = districtRepository.findOne(this.district.getDistrictId());
        this.district.setDistrictId(found.getDistrictId());
        this.district.setCityId(found.getCityId());
        this.district.setName(found.getName());
    }

    public List<DistrictView> findAllDistricts() {
        List<DistrictView> districts = new ArrayList<DistrictView>();
        for(District entity : this.districtRepository.findAll()) {
            DistrictView view = new DistrictView();
            view.setDistrictId(entity.getDistrictId());
            view.setCityId(entity.getCityId());
            view.setName(entity.getName());
            districts.add(view);
        }
        return districts;
    }

    public DistrictView getDistrict() {
        return district;
    }

    public void setDistrict(DistrictView district) {
        this.district = district;
    }

    public DistrictRepository getDistrictRepository() {
        return districtRepository;
    }

    public void setDistrictRepository(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
}
