package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bean.Score;
import util.DBUtil;

public class ScoreDAO {
    public int getTotal() {
        int total = 0;
        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select count(*) from score";

            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return total;
    }

    public void add(Score bean) {

        String sql = "insert into score values(null,?,?,?)";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

//            ps.setString(1, bean.getName());
            ps.setInt(1,bean.getCourseId());
            ps.setInt(2,bean.getStudentId());
            ps.setInt(3, bean.getScore());

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

    public void update(Score bean) {

        String sql = "update score set courseId=?,studentId=?,name= ? where id = ?";
        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1,bean.getCourseId());
            ps.setInt(2,bean.getStudentId());
            ps.setInt(3, bean.getScore());
//            ps.setString(1, bean.getName());
            ps.setInt(4, bean.getId());

            ps.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public void delete(int id) {

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "delete from score where id = " + id;

            s.execute(sql);

        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public Score get(int id) {
        Score bean = null;

        try (Connection c = DBUtil.getConnection(); Statement s = c.createStatement();) {

            String sql = "select * from score where id = " + id;

            ResultSet rs = s.executeQuery(sql);

            if (rs.next()) {
                bean = new Score();
                int courseId = rs.getInt("courseId");
                int studentId = rs.getInt("studentId");
                int score = rs.getInt("score");
//                bean.setName(name);
                bean.setId(id);
                bean.setCourseId(courseId);
                bean.setStudentId(studentId);
                bean.setScore(score);
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }
        return bean;
    }

    public List<Score> list() {
        return list(0, Short.MAX_VALUE);
    }

    public List<Score> list(int start, int count) {
        List<Score> beans = new ArrayList<Score>();

        String sql = "select * from score order by id desc limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, start);
            ps.setInt(2, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Score bean = new Score();
                int id = rs.getInt(1);
                int courseId = rs.getInt("courseId");
                int studentId = rs.getInt("studentId");
                int score = rs.getInt("score");
                bean.setId(id);
                bean.setCourseId(courseId);
                bean.setStudentId(studentId);
                bean.setScore(score);
//                bean.setName(name);
                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }

    public List<Score> list(int id, int start, int count) {
        List<Score> beans = new ArrayList<Score>();

        String sql = "select * from score where id = ? limit ?,? ";

        try (Connection c = DBUtil.getConnection(); PreparedStatement ps = c.prepareStatement(sql);) {

            ps.setInt(1, id);
            ps.setInt(2, start);
            ps.setInt(3, count);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Score bean = new Score();
//                int id = rs.getInt(1);
                int courseId = rs.getInt("courseId");
                int studentId = rs.getInt("studentId");
                int score = rs.getInt("score");

                System.out.println("id="+id);
                System.out.println("courseId="+courseId);
                System.out.println("studentId="+studentId);
                System.out.println("score="+score);

                bean.setId(id);
                bean.setCourseId(courseId);
                bean.setStudentId(studentId);
                bean.setScore(score);

                beans.add(bean);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return beans;
    }
}
