package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.Category;
import cn.itcast.travel.service.CategoryService;
import cn.itcast.travel.service.impl.CategoryServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/category/*")
public class CategoryServlet extends BaseServlet {
    private CategoryService service=new CategoryServiceImpl();
    public void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Category> cs=service.findAll();
        writeValue(cs,response);
    }
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("cid");
        Category cs=service.findOne(Integer.parseInt(cid));
        writeValue(cs,response);
    }
}
