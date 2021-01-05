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

import bean.Student;
//import util.ImageUtil;
import util.Page;

public class StudentServlet extends BaseBackServlet {

    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        int classId= Integer.parseInt(params.get("classId"));
        String password= params.get("password");
        String name= params.get("name");
        int sex = Integer.parseInt(params.get("sex"));
        int age = Integer.parseInt(params.get("age"));

        Student c = new Student();
        c.setClassId(classId);
        c.setPassword(password);
        c.setName(name);
        c.setSex(sex);
        c.setAge(age);
        studentDAO.add(c);

        return "@admin_student_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        studentDAO.delete(id);
        return "@admin_student_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Student c = studentDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editStudent.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);

        int id = Integer.parseInt(params.get("id"));
        int classId = Integer.parseInt(params.get("classId"));
        String password= params.get("password");
        String name= params.get("name");
        int sex = Integer.parseInt(params.get("sex"));
        int age = Integer.parseInt(params.get("age"));
        String title= params.get("title");
        String phone= params.get("phone");

        Student c = new Student();
        c.setId(id);
        c.setClassId(classId);
        c.setPassword(password);
        c.setName(name);
        c.setSex(sex);
        c.setAge(age);
        studentDAO.update(c);

        return "@admin_student_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Student> cs = studentDAO.list(page.getStart(),page.getCount());
        int total = studentDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);


        request.setAttribute("page", page);

        return "admin/listStudent.jsp";
    }

    //student使用
    public String editStudent(HttpServletRequest request, HttpServletResponse response, Page page) {
//        int id = Integer.parseInt(request.getParameter("id"));
        int id = (int)request.getSession().getAttribute("id");
        Student c = studentDAO.get(id);
        request.setAttribute("c", c);
        return "student/editStudent.jsp";
    }
}
