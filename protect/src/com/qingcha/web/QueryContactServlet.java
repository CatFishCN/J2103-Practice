package com.qingcha.web;

import com.qingcha.admin.ContactInfo;
import com.qingcha.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/query_contact")
public class QueryContactServlet extends HttpServlet {
    private ContactService service = new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        //1.接收数据
        int currentPage = 1;
        String currentPageParam = request.getParameter("currentPage");
        if (currentPageParam != null){
            currentPage = Integer.parseInt(currentPageParam);
        }
        int viewPage = 10;
        String viewPageParam = request.getParameter("viewPage");
        if (viewPageParam != null){
            viewPage = Integer.parseInt(viewPageParam);
        }
        //2.处理数据
        int dataCount = service.queryCount();
        int pages = (int) Math.ceil(dataCount/(double)viewPage);
        List<ContactInfo> contacts = service.queryAll(currentPage,viewPage);

        request.setAttribute("currentPage",currentPage);
        request.setAttribute("viewPage",viewPage);
        request.setAttribute("pages",pages);
        request.setAttribute("contacts",contacts);
        //3.响应数据
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
