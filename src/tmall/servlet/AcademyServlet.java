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

import bean.Academy;
//import util.ImageUtil;
import util.Page;

public class AcademyServlet extends BaseBackServlet {

    public String add(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        String name= params.get("name");
        Academy c = new Academy();
        c.setName(name);
        academyDAO.add(c);

//        File  imageFolder= new File(request.getSession().getServletContext().getRealPath("img/academy"));
//        File file = new File(imageFolder,c.getId()+".jpg");
//
//        try {
//            if(null!=is && 0!=is.available()){
//                try(FileOutputStream fos = new FileOutputStream(file)){
//                    byte b[] = new byte[1024 * 1024];
//                    int length = 0;
//                    while (-1 != (length = is.read(b))) {
//                        fos.write(b, 0, length);
//                    }
//                    fos.flush();
//                    //通过如下代码，把文件保存为jpg格式
//                    BufferedImage img = ImageUtil.change2jpg(file);
//                    ImageIO.write(img, "jpg", file);
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return "@admin_academy_list";
    }

    public String delete(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        academyDAO.delete(id);
        return "@admin_academy_list";
    }

    public String edit(HttpServletRequest request, HttpServletResponse response, Page page) {
        int id = Integer.parseInt(request.getParameter("id"));
        Academy c = academyDAO.get(id);
        request.setAttribute("c", c);
        return "admin/editAcademy.jsp";
    }

    public String update(HttpServletRequest request, HttpServletResponse response, Page page) {
        Map<String,String> params = new HashMap<>();
        InputStream is = super.parseUpload(request, params);

        System.out.println(params);
        String name= params.get("name");
        int id = Integer.parseInt(params.get("id"));

        Academy c = new Academy();
        c.setId(id);
        c.setName(name);
        academyDAO.update(c);

//        File  imageFolder= new File(request.getSession().getServletContext().getRealPath("img/academy"));
//        File file = new File(imageFolder,c.getId()+".jpg");
//        file.getParentFile().mkdirs();
//
//        try {
//            if(null!=is && 0!=is.available()){
//                try(FileOutputStream fos = new FileOutputStream(file)){
//                    byte b[] = new byte[1024 * 1024];
//                    int length = 0;
//                    while (-1 != (length = is.read(b))) {
//                        fos.write(b, 0, length);
//                    }
//                    fos.flush();
//                    //通过如下代码，把文件保存为jpg格式
//                    BufferedImage img = ImageUtil.change2jpg(file);
//                    ImageIO.write(img, "jpg", file);
//                }
//                catch(Exception e){
//                    e.printStackTrace();
//                }
//            }
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
        return "@admin_academy_list";

    }

    public String list(HttpServletRequest request, HttpServletResponse response, Page page) {
        List<Academy> cs = academyDAO.list(page.getStart(),page.getCount());
        int total = academyDAO.getTotal();
        page.setTotal(total);

        request.setAttribute("thecs", cs);
        request.setAttribute("page", page);

        return "admin/listAcademy.jsp";
    }
}
