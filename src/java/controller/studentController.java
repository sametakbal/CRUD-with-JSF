/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.StudentDao;
import entity.Student;
import java.util.List;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author samet
 */
@Named
@SessionScoped
public class studentController implements Serializable{
    private List<Student> slist;
    private StudentDao studentDao;
    private Student student;

    public studentController() {
    }
    
    public String save(){
        getStudentDao().create(this.student);
        return "index";
    }
    public String update(){
        getStudentDao().update(this.student);
        clearForm();
        return "index";
    }
     public String delete(){
        getStudentDao().delete(this.student);
        clearForm();
        return "index";
    }
    public void updateForm(Student stu){
        this.student = stu;
    }
     public void clearForm(){
        this.student = new Student();
    }

    public Student getStudent() {
        if (student == null) {
            student = new Student();
        }
        return student;
    }
    

    public List<Student> getSlist() {
        slist = getStudentDao().read();
        return slist;
    }

    public StudentDao getStudentDao() {
        if (studentDao == null) {
            studentDao = new StudentDao();
        }
        return studentDao;
    }
}