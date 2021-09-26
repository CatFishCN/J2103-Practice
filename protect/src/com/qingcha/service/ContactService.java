package com.qingcha.service;

import com.qingcha.admin.ContactInfo;
import com.qingcha.dao.ContactDAO;

import java.util.List;

/**
 * projectName: java_test
 *
 * @author: zx
 * time: 2021/9/23 18:28
 * description:
 */

public class ContactService {
    private ContactDAO dao = new ContactDAO();
    public int queryCount() {
        return dao.queryCount();
    }

    public List<ContactInfo> queryAll(int currentPage, int viewPage) {
        int pageOffset = (currentPage-1)*viewPage;
        return dao.queryAll(pageOffset,viewPage);
    }

    public boolean add(ContactInfo contactInfo) {
        return dao.add(contactInfo)==1;
    }

    public boolean delete(String delId) {
        return dao.delete(delId)==1;
    }


    public ContactInfo queryById(String updateId) {
        return dao.queryById(updateId);
    }

    public boolean update(ContactInfo contact) {
        return dao.update(contact)==1;
    }

    public int checkLogin(String user, String password) {
        if (dao.checkLogin(user, password) == null){
            return 0;
        }else return 1;
    }
}

