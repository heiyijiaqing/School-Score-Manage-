package servlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Score;
//import util.ImageUtil;
import bean.Student;
import util.Page;

public class ScoreServlet extends BaseBackServlet {

    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        int courseId = Integer.parseInt(params.get("courseId"));
        int studentId = Integer.parseInt(params.get("studentId"));
        int score = Integer.parseInt(params.get("score"));


        Score c = new Score();
        c.setCourseId(courseId);
        c.setStudentId(studentId);
        c.setScore(score);

        scoreDAO.add(c);

        return "@admin_score_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        scoreDAO.delete(id);
        return "@admin_score_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Score c = scoreDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editScore.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);

        int id = Integer.parseInt(params.get("id"));

        int courseId = Integer.parseInt(params.get("courseId"));
        int studentId = Integer.parseInt(params.get("studentId"));
        int score = Integer.parseInt(params.get("score"));

        Score c = new Score();
        c.setId(id);
        c.setCourseId(courseId);
        c.setStudentId(studentId);
        c.setScore(score);
        scoreDAO.update(c);

        return "@admin_score_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Score> cs = scoreDAO.list(page.getStart(),page.getCount());
        int total = scoreDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);


        request.setAttribute("page", page);

        return "admin/listScore.jsp";
    }

//    student
    public String listStudent(HttpServletRequest request, HttpServletResponse response, Page page) {
//        int id = Integer.parseInt(request.getParameter("id"));

        int id = (int) request.getSession().getAttribute("id");

        List<Score> cs = scoreDAO.list(id,page.getStart(),page.getCount());
        int total = scoreDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);

        request.setAttribute("page", page);

        return "student/listScore.jsp";

    }
}
