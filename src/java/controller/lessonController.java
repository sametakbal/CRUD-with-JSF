/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import entity.Lesson;
import dao.LessonDao;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author samet
 */
@Named
@SessionScoped
public class lessonController implements Serializable {

    private List<Lesson> list;
    private LessonDao ldao;
    private Lesson lesson;

    public lessonController() {
    }
    public void updateForm(Lesson ls){
       this.lesson = ls;
    }
    public void clearForm(){
        lesson = new Lesson();
    }
    public String save(){
        getLdao().create(this.lesson);
        clearForm();
        return "lesson";
    }
    public String modify(){
        getLdao().update(this.lesson);
        return "lesson";
    }
    
    public String remove(){
        getLdao().delete(this.lesson);
        clearForm();
        return "lesson";
    }

    public List<Lesson> getList() {
        this.list = getLdao().read();
        return list;
    }

    public LessonDao getLdao() {
        if (ldao == null) {
            ldao = new LessonDao();
        }
        return ldao;
    }

    public Lesson getLesson() {
        if (lesson == null) {
            lesson = new Lesson();
        }
        return lesson;
    }

    public void setLesson(Lesson lesson) {
        this.lesson = lesson;
    }
    
}
