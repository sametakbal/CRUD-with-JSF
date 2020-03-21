/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Lesson;
import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author samet
 */
public class LessonDao extends Dao {

    @Override
    public void create(Object obj) {
        String q = "insert into lesson values(default,?)";
        Lesson ls = (Lesson) obj;
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setString(1, ls.getName());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List read() {
        String q = "select * from lesson";
        List<Lesson> list = new ArrayList<>();
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Lesson tmp = new Lesson(rs.getInt(1), rs.getString(2));
                list.add(tmp);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    @Override
    public void update(Object obj) {
        String q = "update lesson set name=? where id=?";
        Lesson ls = (Lesson) obj;
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setString(1, ls.getName());
            pst.setInt(2, ls.getId());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void delete(Object obj) {
        String q = "delete from lesson where id=?";
        Lesson ls = (Lesson) obj;
        try {
            PreparedStatement pst = getConn().prepareStatement(q);
            pst.setInt(1, ls.getId());
            pst.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
