package com.bekirsubasi.primefaces.view;


import com.bekirsubasi.primefaces.domain.Student;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean(name = "student", eager = true)
@RequestScoped
public class StudentView extends Student {

    public StudentView() { }
    
}
