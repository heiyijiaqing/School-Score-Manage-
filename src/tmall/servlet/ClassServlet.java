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

import bean.Class;
//import util.ImageUtil;
import util.Page;

public class ClassServlet extends BaseBackServlet  {


    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        int majorId= Integer.parseInt(params.get("majorId"));
        String name= params.get("name");

        Class c = new Class();
        c.setMajorId(majorId);
        c.setName(name);
        classDAO.add(c);

        return "@admin_class_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        classDAO.delete(id);
        return "@admin_class_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Class c = classDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editClass.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);
        String name= params.get("name");
        int id = Integer.parseInt(params.get("id"));

        Class c = new Class();
        c.setId(id);
        c.setName(name);
        classDAO.update(c);

        return "@admin_class_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Class> cs = classDAO.list(page.getStart(),page.getCount());
        int total = classDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);


        request.setAttribute("page", page);

        return "admin/listClass.jsp";
    }
}
