package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Student;
import util.DBUtil;

public class StudentDAO {

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from student";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Student bean) {

        String sql = "insert into student values(null ,? ,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getClassId());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getSex());
            ps.setInt(5, bean.getAge());

            ps.execute();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                int id = rs.getInt(1);
                bean.setId(id);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void update(Student bean) {

        String sql = "update student set classId=?, password=? ,name= ? , sex = ?,age=? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getClassId());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getSex());
            ps.setInt(5, bean.getAge());

            ps.setInt(6,bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from student where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Student get(int id) {
        Student bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from student where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Student();

                int classId = rs.getInt("classId");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");

                bean.setId(id);
                bean.setClassId(classId);
                bean.setPassword(password);
                bean.setName(name);
                bean.setSex(sex);
                bean.setAge(age);

            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Student> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Student> list(int start, int count) {
        List<Student> beans = new ArrayList<Student>();

        String sql = "select * from student order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Student bean = new Student();

                int id = rs.getInt(1);
                int classId = rs.getInt("classId");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");

                bean.setId(id);
                bean.setClassId(classId);
                bean.setName(name);
                bean.setPassword(password);
                bean.setSex(sex);
                bean.setAge(age);

                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public boolean isExist(String name) {
        Student bean = get(name);
        return bean!=null;

    }

    public Student get(String name) {
        Student bean = null;

        String sql = "select * from student where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new Student();
                int id = rs.getInt("id");
                bean.setName(name);
                String password = rs.getString("password");
                bean.setPassword(password);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public Student get(String name, String password) {
        Student bean = null;

        String sql = "select * from student where name = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new Student();
                int id = rs.getInt("id");
                bean.setName(name);
                bean.setPassword(password);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }
}
