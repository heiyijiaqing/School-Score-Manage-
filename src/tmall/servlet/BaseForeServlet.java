package servlet;

import dao.*;
import util.Page;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

public abstract class BaseForeServlet extends HttpServlet {

    public abstract String login(HttpServletRequest request, HttpServletResponse response, Page page) ;

    protected AcademyDAO academyDAO = new AcademyDAO();
    protected AdminDAO adminDAO = new AdminDAO();
    protected CheckDAO checkDAO = new CheckDAO();
    protected ClassDAO classDAO = new ClassDAO();
    protected CourseDAO courseDAO = new CourseDAO();
    protected MajorDAO majorDAO = new MajorDAO();
    protected ScoreDAO scoreDAO = new ScoreDAO();
    protected StudentDAO studentDAO = new StudentDAO();
    protected TeacherDAO teacherDAO = new TeacherDAO();

    public void service(HttpServletRequest request, HttpServletResponse response) {
        try {

            int start= 0;
            int count = 10;
            try {
                start = Integer.parseInt(request.getParameter("page.start"));
            } catch (Exception e) {

            }

            try {
                count = Integer.parseInt(request.getParameter("page.count"));
            } catch (Exception e) {
            }

            Page page = new Page(start,count);

            String method = (String) request.getAttribute("method");

            Method m = this.getClass().getMethod(method, javax.servlet.http.HttpServletRequest.class,
                    javax.servlet.http.HttpServletResponse.class,Page.class);

            String redirect = m.invoke(this,request, response,page).toString();

            if(redirect.startsWith("@"))
                response.sendRedirect(redirect.substring(1));
            else if(redirect.startsWith("%"))
                response.getWriter().print(redirect.substring(1));
            else
                request.getRequestDispatcher(redirect).forward(request, response);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
