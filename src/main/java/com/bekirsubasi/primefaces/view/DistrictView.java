package com.bekirsubasi.primefaces.view;


import com.bekirsubasi.primefaces.domain.District;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "district", eager = true)
@RequestScoped
public class DistrictView extends District {

    public DistrictView() { }
    
}
