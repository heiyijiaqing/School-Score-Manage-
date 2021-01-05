package dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Teacher;
import util.DBUtil;

public class TeacherDAO {

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from teacher";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Teacher bean) {

        String sql = "insert into teacher values(null ,? ,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getAcademyId());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getSex());
            ps.setInt(5, bean.getAge());
            ps.setString(6, bean.getTitle());
            ps.setString(7, bean.getPhone());

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

    public void update(Teacher bean) {

        String sql = "update teacher set academyId=?, password=? ,name= ? , sex = ?,age=?,title=?,phone=? where id = ? ";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getAcademyId());
            ps.setString(2, bean.getPassword());
            ps.setString(3, bean.getName());
            ps.setInt(4, bean.getSex());
            ps.setInt(5, bean.getAge());
            ps.setString(6, bean.getTitle());
            ps.setString(7, bean.getPhone());

            ps.setInt(8,bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from teacher where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Teacher get(int id) {
        Teacher bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from teacher where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Teacher();

                int academyId = rs.getInt("academyId");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
                String title = rs.getString("title");
                String phone = rs.getString("phone");

                bean.setId(id);
                bean.setAcademyId(academyId);
                bean.setPassword(password);
                bean.setName(name);
                bean.setSex(sex);
                bean.setAge(age);
                bean.setTitle(title);
                bean.setPhone(phone);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Teacher> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Teacher> list(int start, int count) {
        List<Teacher> beans = new ArrayList<Teacher>();

        String sql = "select * from teacher order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Teacher bean = new Teacher();
                int id = rs.getInt(1);
                int academyId = rs.getInt("academyId");
                String password = rs.getString("password");
                String name = rs.getString("name");
                int sex = rs.getInt("sex");
                int age = rs.getInt("age");
                String title = rs.getString("title");
                String phone = rs.getString("phone");

                bean.setId(id);
                bean.setAcademyId(academyId);
                bean.setName(name);
                bean.setPassword(password);
                bean.setSex(sex);
                bean.setAge(age);
                bean.setTitle(title);
                bean.setPhone(phone);

                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public boolean isExist(String name) {
        Teacher bean = get(name);
        return bean!=null;

    }

    public Teacher get(String name) {
        Teacher bean = null;

        String sql = "select * from teacher where name = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, name);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new Teacher();
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

    public Teacher get(int id, String password) {
        Teacher bean = null;

        String sql = "select * from teacher where id = ? and password=?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, password);
            ResultSet rs =ps.executeQuery();

            if (rs.next()) {
                bean = new Teacher();
//                int id = rs.getInt("id");
//                bean.setName(name);
                bean.setPassword(password);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

}
