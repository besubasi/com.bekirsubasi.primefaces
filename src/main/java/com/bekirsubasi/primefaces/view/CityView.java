package com.bekirsubasi.primefaces.view;




import com.bekirsubasi.primefaces.domain.City;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;



@ManagedBean(name = "city", eager = true)
@RequestScoped
public class CityView extends City {

    public CityView() { }
    
}
