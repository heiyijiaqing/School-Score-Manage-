package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Class;
import util.DBUtil;

public class ClassDAO {

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from class";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Class bean) {

        String sql = "insert into class values(null,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getMajorId());
            ps.setString(2, bean.getName());

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

    public void update(Class bean) {

        String sql = "update class set name= ? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setString(1, bean.getName());
            ps.setInt(2, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from class where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Class get(int id) {
        Class bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from class where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Class();
                int majorId = rs.getInt("majorId");
                String name = rs.getString("name");
                bean.setMajorId(majorId);
                bean.setName(name);
                bean.setId(id);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Class> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Class> list(int start, int count) {
        List<Class> beans = new ArrayList<Class>();

        String sql = "select * from class order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Class bean = new Class();
                int id = rs.getInt(1);
                int majorId = rs.getInt("majorId");
                String name = rs.getString("name");
                bean.setId(id);
                bean.setMajorId(majorId);
                bean.setName(name);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
