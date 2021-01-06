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

import bean.Teacher;
//import util.ImageUtil;
import util.Page;

public class TeacherServlet extends BaseBackServlet {

    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        int academyId= Integer.parseInt(params.get("academyId"));
        String password= params.get("password");
        String name= params.get("name");
        int sex = Integer.parseInt(params.get("sex"));
        int age = Integer.parseInt(params.get("age"));
        String title= params.get("title");
        String phone= params.get("phone");

        Teacher c = new Teacher();
        c.setAcademyId(academyId);
        c.setPassword(password);
        c.setName(name);
        c.setSex(sex);
        c.setAge(age);
        c.setTitle(title);
        c.setPhone(phone);
        teacherDAO.add(c);

        return "@admin_teacher_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        teacherDAO.delete(id);
        return "@admin_teacher_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Teacher c = teacherDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editTeacher.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);

        int id = Integer.parseInt(params.get("id"));
        int academyId = Integer.parseInt(params.get("academyId"));
        String password= params.get("password");
        String name= params.get("name");
        int sex = Integer.parseInt(params.get("sex"));
        int age = Integer.parseInt(params.get("age"));
        String title= params.get("title");
        String phone= params.get("phone");

        Teacher c = new Teacher();
        c.setId(id);
        c.setAcademyId(academyId);
        c.setPassword(password);
        c.setName(name);
        c.setSex(sex);
        c.setAge(age);
        c.setTitle(title);
        c.setPhone(phone);
        teacherDAO.update(c);

        return "@admin_teacher_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Teacher> cs = teacherDAO.list(page.getStart(),page.getCount());
        int total = teacherDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);


        request.setAttribute("page", page);

        return "admin/listTeacher.jsp";
    }

//    教师使用
    public String editTeacher(HttpServletRequest request, HttpServletResponse response, Page page) {
//        int id = Integer.parseInt(request.getParameter("id"));
        int id = (int)request.getSession().getAttribute("id");
        Teacher c = teacherDAO.get(id);
        request.setAttribute("c", c);
        return "teacher/editTeacher.jsp";
    }

    public String updateTeacher(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);

        int id = Integer.parseInt(params.get("id"));
        int academyId = Integer.parseInt(params.get("academyId"));
        String password= params.get("password");
        String name= params.get("name");
        int sex = Integer.parseInt(params.get("sex"));
        int age = Integer.parseInt(params.get("age"));
        String title= params.get("title");
        String phone= params.get("phone");

        Teacher c = new Teacher();
        c.setId(id);
        c.setAcademyId(academyId);
        c.setPassword(password);
        c.setName(name);
        c.setSex(sex);
        c.setAge(age);
        c.setTitle(title);
        c.setPhone(phone);
        teacherDAO.update(c);

        return "@teacher_teacher_editTeacher";

    }
}
