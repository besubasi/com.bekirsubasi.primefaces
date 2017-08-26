package com.bekirsubasi.primefaces.view;


import com.bekirsubasi.primefaces.domain.District;
import com.bekirsubasi.primefaces.domain.Student;
import com.bekirsubasi.primefaces.persistence.DistrictRepository;
import com.bekirsubasi.primefaces.persistence.StudentRepository;

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
@ManagedBean(name = "studentModel", eager = true)
@RequestScoped
public class StudentModel {

    @ManagedProperty(value = "#{student}")
    private StudentView student;


    @ManagedProperty(value = "#{studentRepository}")
    private StudentRepository studentRepository;


    public String doCreateStudent() {
        Student created = new Student();
        created.setStudentId(this.student.getStudentId());
        created.setCityId(this.student.getCityId());
        created.setDistrictId(this.student.getDistrictId());
        created.setName(this.student.getName());
        created.setSurname(this.student.getSurname());
        created.setMobilePhone(this.student.getMobilePhone());
        created.setDescription(this.student.getDescription());

        Student newStudent = this.studentRepository.save(created);

        FacesContext.getCurrentInstance().addMessage("errors",
            new FacesMessage(FacesMessage.SEVERITY_INFO, "Student created",
                "The student " + created.getName() + " has been created with id=" + newStudent.getStudentId()));

        this.student.setCityId(null);
        this.student.setDistrictId(null);
        this.student.setName("");
        this.student.setSurname("");
        this.student.setMobilePhone("");
        this.student.setDescription("");

        return "student.xhtml";
    }

    public void doFindStudentById() {
        Student found = studentRepository.findOne(this.student.getStudentId());
        this.student.setStudentId(found.getStudentId());
        this.student.setCityId(found.getCityId());
        this.student.setDistrictId(found.getDistrictId());
        this.student.setName(found.getName());
        this.student.setSurname(found.getSurname());
        this.student.setMobilePhone(found.getMobilePhone());
        this.student.setDescription(found.getDescription());

    }

    public List<StudentView> findAllStudents() {
        List<StudentView> students = new ArrayList<StudentView>();
        for(Student student : this.studentRepository.findAll()) {
            StudentView view = new StudentView();

            view.setStudentId(student.getStudentId());
            view.setCityId(student.getCityId());
            view.setDistrictId(student.getDistrictId());
            view.setName(student.getName());
            view.setSurname(student.getSurname());
            view.setMobilePhone(student.getMobilePhone());
            view.setDescription(student.getDescription());


            students.add(view);
        }
        return students;
    }

    public StudentView getStudent() {
        return student;
    }

    public void setStudent(StudentView student) {
        this.student = student;
    }

    public StudentRepository getStudentRepository() {
        return studentRepository;
    }

    public void setStudentRepository(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }
}
