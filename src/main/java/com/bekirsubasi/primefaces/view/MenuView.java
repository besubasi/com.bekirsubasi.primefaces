package com.bekirsubasi.primefaces.view;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class MenuView {

    private MenuModel model;


    public MenuView(){
        model = new DefaultMenuModel();

        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Menu List");

        DefaultMenuItem item = new DefaultMenuItem("City");
        item.setUrl("/city.jsf");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);

        item = new DefaultMenuItem("District");
        item.setUrl("/district.jsf");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);


        item = new DefaultMenuItem("Student");
        item.setUrl("/student.jsf");
        item.setIcon("ui-icon-home");
        firstSubmenu.addElement(item);



        model.addElement(firstSubmenu);

    }

    public MenuModel getModel() {
        return model;
    }

    public void save() {
        addMessage("Success", "Data saved");
    }

    public void update() {
        addMessage("Success", "Data updated");
    }

    public void delete() {
        addMessage("Success", "Data deleted");
    }

    public void addMessage(String summary, String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}