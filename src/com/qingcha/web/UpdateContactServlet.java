package com.qingcha.web;

import com.qingcha.admin.ContactInfo;
import com.qingcha.service.ContactService;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/update_contact")
public class UpdateContactServlet extends HttpServlet {
    protected ContactService service = new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //���ñ���
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        //1.��������
        Map<String, String[]> parameterMap = request.getParameterMap();
        ContactInfo contact = new ContactInfo();
        try {
            BeanUtils.populate(contact,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2.��������
        service.update(contact);
        //3.��Ӧ����
        response.sendRedirect("query_contact");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
