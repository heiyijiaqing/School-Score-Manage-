package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.util.HtmlUtils;

import bean.Admin;
import bean.Teacher;
import bean.Student;
import dao.AdminDAO;
import dao.TeacherDAO;
import dao.StudentDAO;
import util.Page;

public class ForeServlet extends BaseForeServlet {

    public String login(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
//        name = HtmlUtils.htmlEscape(name);
        String password = request.getParameter("password");
        int type = Integer.parseInt(request.getParameter("type"));

        //存储用户登录id
//        request.setAttribute("id",id);
        request.getSession().setAttribute("id",id);

        switch (type) {
            case 0: {
                Student student = studentDAO.get(id, password);
                if (null == student) {
                    request.setAttribute("msg", "账号密码错误");
                    return "login.jsp";
                }
                request.getSession().setAttribute("student", student);
                return "@student_score_listStudent?id="+id;
            }
            case 1: {
                Teacher teacher = teacherDAO.get(id, password);
                if (null == teacher) {
                    request.setAttribute("msg", "账号密码错误");
                    return "login.jsp";
                }
                request.getSession().setAttribute("teacher", teacher);
                return "@teacher_course_listTeacher?id="+id;
            }
            case 2: {
                Admin admin = adminDAO.get(id, password);
                if (null == admin) {
                    request.setAttribute("msg", "账号密码错误");
                    return "login.jsp";
                }
                request.getSession().setAttribute("admin", admin);

                return "@admin_academy_list";
            }
        }

//        User user = userDAO.get(name,password);

//        if(null==user){
//            request.setAttribute("msg", "账号密码错误");
//            return "login.jsp";
//        }
//        request.getSession().setAttribute("user", user);
        return "login.jsp";
    }


}
