/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author samet
 */
public class StudentDao extends Dao {

    @Override
    public void create(Object obj) {
        String q = "insert into student values(default,?,?,?)";
        Student stu = (Student) obj;
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setString(1, stu.getName());
            pst.setString(2, stu.getSurname());
            pst.setInt(3, stu.getAge());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List read() {
        String q = "select * from student";
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Student tmp = new Student(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Object obj) {
        String q = "update student set name=?,surname=?,age=? where id=?";
        Student stu = (Student) obj;
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setString(1, stu.getName());
            pst.setString(2, stu.getSurname());
            pst.setInt(3, stu.getAge());
            pst.setInt(4,stu.getId());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
          String q = "delete from student where id=?";
        Student stu = (Student) obj;
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setInt(1,stu.getId());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
