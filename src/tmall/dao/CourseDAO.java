package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Course;
import util.DBUtil;

public class CourseDAO {

    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from course";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Course bean) {

        String sql = "insert into course values(null,?,?,?,?,?,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getClassId());
            ps.setInt(2,bean.getTeacherId());
            ps.setString(3, bean.getName());
            ps.setString(4, bean.getYear());
            ps.setInt(5, bean.getTerm());
            ps.setInt(6, bean.getHour());
            ps.setInt(7, bean.getType());
            ps.setInt(8, bean.getCredit());

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

    public void update(Course bean) {

        String sql = "update course set classId=?,teacherId=?,name= ?,year=?,term=?,hour=?,type=?,credit=? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getClassId());
            ps.setInt(2,bean.getTeacherId());
            ps.setString(3, bean.getName());
            ps.setString(4, bean.getYear());
            ps.setInt(5, bean.getTerm());
            ps.setInt(6, bean.getHour());
            ps.setInt(7, bean.getType());
            ps.setInt(8, bean.getCredit());

            ps.setInt(9, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from course where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Course get(int id) {
        Course bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from course where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Course();

                int classId = rs.getInt("classId");
                int teacherId = rs.getInt("teacherId");
                String name = rs.getString("name");
                String year = rs.getString("year");
                int term = rs.getInt("term");
                int hour = rs.getInt("hour");
                int type = rs.getInt("type");
                int credit = rs.getInt("credit");

                bean.setId(id);
                bean.setClassId(classId);
                bean.setTeacherId(teacherId);
                bean.setName(name);
                bean.setYear(year);
                bean.setTerm(term);
                bean.setHour(hour);
                bean.setType(type);
                bean.setCredit(credit);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Course> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Course> list(int start, int count) {
        List<Course> beans = new ArrayList<Course>();

        String sql = "select * from course order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Course bean = new Course();
                int id = rs.getInt(1);
                int classId = rs.getInt("classId");
                int teacherId = rs.getInt("teacherId");
                String name = rs.getString("name");
                String year = rs.getString("year");
                int term = rs.getInt("term");
                int hour = rs.getInt("hour");
                int type = rs.getInt("type");
                int credit = rs.getInt("credit");

                bean.setId(id);
                bean.setClassId(classId);
                bean.setTeacherId(teacherId);
                bean.setName(name);
                bean.setYear(year);
                bean.setTerm(term);
                bean.setHour(hour);
                bean.setType(type);
                bean.setCredit(credit);

                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
