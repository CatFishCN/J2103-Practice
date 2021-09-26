package com.qingcha.web;

import com.qingcha.admin.ContactInfo;
import com.qingcha.service.ContactService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/broker_contact")
public class BrokerContactServlet extends HttpServlet {
    private ContactService service = new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ���
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        //1.��������
        String updateId = request.getParameter("id");
        //2.��������
        ContactInfo contact =  service.queryById(updateId);
        request.setAttribute("contact",contact);
        //3.��Ӧ����
        request.getRequestDispatcher("/update.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
