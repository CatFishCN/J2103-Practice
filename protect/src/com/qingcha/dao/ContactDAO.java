package com.qingcha.dao;

import com.qingcha.admin.ContactInfo;
import com.qingcha.listener.DataSourceManager;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * projectName: java_test
 *
 * @author: zx
 * time: 2021/9/23 18:30
 * description:
 */

public class ContactDAO {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(DataSourceManager.getDs());
    public int queryCount() {
        return jdbcTemplate.queryForObject("select count(*) from contact_info where del = 0", Integer.class);
    }

    public List<ContactInfo> queryAll(int pageOffset, int viewPage) {
        return jdbcTemplate.query("select * from contact_info where del = 0 limit ?,? ",
                new BeanPropertyRowMapper<>(ContactInfo.class), pageOffset, viewPage);
    }

    public int add(ContactInfo contactInfo) {
        return jdbcTemplate.update("insert into contact_info (`name`,`gender`,`birthday`,`birthplace`,`mobile`,`email`) values (?,?,?,?,?,?) ",
                contactInfo.getName(),
                contactInfo.getGender(),
                contactInfo.getBirthday(),
                contactInfo.getBirthplace(),
                contactInfo.getMobile(),
                contactInfo.getEmail());
    }

    public int delete(String delId) {
        return jdbcTemplate.update("update contact_info set del = 1 where id = ?", delId);
    }

    public ContactInfo queryById(String updateId) {
        ContactInfo result = null;
        try {
            result = jdbcTemplate.queryForObject("select * from contact_info where  id = ? and del = 0",
                    new BeanPropertyRowMapper<>(ContactInfo.class),updateId);
        }catch (Exception e){}
        return result;
    }

    public int update(ContactInfo contact) {
        return jdbcTemplate.update("update contact_info set name=?,gender=?,birthday=?,birthplace=?,mobile=?,email=? where id=?",
                contact.getName(),
                contact.getGender(),
                contact.getBirthday(),
                contact.getBirthplace(),
                contact.getMobile(),
                contact.getEmail(),
                contact.getId());
    }

    public ContactInfo checkLogin(String user, String password) {
        ContactInfo result = null;
        try {
            result = jdbcTemplate.queryForObject("select * from user where username=? and password =?",
                    new BeanPropertyRowMapper<>(ContactInfo.class),user,password);
        }catch (Exception e){}
        return result;
    }
}

