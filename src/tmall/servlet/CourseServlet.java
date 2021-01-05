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

import bean.Course;
//import util.ImageUtil;
import util.Page;

public class CourseServlet extends BaseBackServlet {

    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        int classId = Integer.parseInt(params.get("classId"));
        int teacherId = Integer.parseInt(params.get("teacherId"));
        String name = params.get("name");
        String year = params.get("year");
        int term = Integer.parseInt(params.get("term"));
        int hour = Integer.parseInt(params.get("hour"));
        int type = Integer.parseInt(params.get("type"));
        int credit = Integer.parseInt(params.get("credit"));

        Course c = new Course();
        c.setClassId(classId);
        c.setTeacherId(teacherId);
        c.setName(name);
        c.setYear(year);
        c.setTerm(term);
        c.setHour(hour);
        c.setType(type);
        c.setCredit(credit);

        courseDAO.add(c);

        return "@admin_course_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        courseDAO.delete(id);
        return "@admin_course_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Course c = courseDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editCourse.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);

        int id = Integer.parseInt(params.get("id"));

        int classId = Integer.parseInt(params.get("classId"));
        int teacherId = Integer.parseInt(params.get("teacherId"));
        String name = params.get("name");
        String year = params.get("year");
        int term = Integer.parseInt(params.get("term"));
        int hour = Integer.parseInt(params.get("hour"));
        int type = Integer.parseInt(params.get("type"));
        int credit = Integer.parseInt(params.get("credit"));

        Course c = new Course();
        c.setId(id);
        c.setClassId(classId);
        c.setTeacherId(teacherId);
        c.setName(name);
        c.setYear(year);
        c.setTerm(term);
        c.setHour(hour);
        c.setType(type);
        c.setCredit(credit);
        courseDAO.update(c);

        return "@admin_course_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Course> cs = courseDAO.list(page.getStart(),page.getCount());
        int total = courseDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);


        request.setAttribute("page", page);

        return "admin/listCourse.jsp";
    }
}
