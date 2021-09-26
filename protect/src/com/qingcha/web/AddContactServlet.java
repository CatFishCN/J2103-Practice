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

@WebServlet("/add_contact")
public class AddContactServlet extends HttpServlet {
    private ContactService service = new ContactService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
//        request.setCharacterEncoding("utf-8");
//        response.setContentType("text/html;charset=utf-8");

        //1.接收数据
        Map<String, String[]> parameterMap = request.getParameterMap();
        ContactInfo contactInfo = new ContactInfo();
        try {
            BeanUtils.populate(contactInfo,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //2.处理数据
        service.add(contactInfo);
        //3.响应数据
        response.sendRedirect("query_contact");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
