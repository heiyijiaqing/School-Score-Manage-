package filter;

import java.io.IOException;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Admin;
import bean.Student;
import bean.Teacher;
import org.apache.commons.lang.StringUtils;



public class ForeServletFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        String contextPath=request.getServletContext().getContextPath();
        request.getServletContext().setAttribute("contextPath", contextPath);

        Admin admin =(Admin) request.getSession().getAttribute("admin");
        Teacher teacher =(Teacher) request.getSession().getAttribute("teacher");
        Student student =(Student) request.getSession().getAttribute("student");
//        int cartTotalItemNumber= 0;
//        if(null!=user){
//            List<OrderItem> ois = new OrderItemDAO().listByUser(user.getId());
//            for (OrderItem oi : ois) {
//                cartTotalItemNumber+=oi.getNumber();
//            }
//        }
//        request.setAttribute("cartTotalItemNumber", cartTotalItemNumber);

//        List<Category> cs=(List<Category>) request.getAttribute("cs");
//        if(null==cs){
//            cs=new CategoryDAO().list();
//            request.setAttribute("cs", cs);
//        }

        String uri = request.getRequestURI();
        uri =StringUtils.remove(uri, contextPath);
        System.out.println("uri="+uri+"\n"+"contextPath="+contextPath);
        if(uri.startsWith("/fore")){
            String method = StringUtils.substringAfterLast(uri,"/fore" );
            System.out.println("method="+method);
            request.setAttribute("method", method);
            req.getRequestDispatcher("/foreServlet").forward(request, response);
            return;
        }


        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
