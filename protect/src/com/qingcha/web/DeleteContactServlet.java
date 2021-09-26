package com.qingcha.web;

import com.qingcha.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/delete_contact")
public class DeleteContactServlet extends HttpServlet {
    private ContactService service = new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ���
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        //1.��������
        String delId = request.getParameter("id");
        //2.��������
        service.delete(delId);
        //3.��Ӧ����
        response.sendRedirect("query_contact");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
