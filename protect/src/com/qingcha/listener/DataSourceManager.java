package com.qingcha.listener;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * projectName: java_test
 *
 * @author: zx
 * time: 2021/9/23 17:22
 * description:
 */
@WebListener
public class DataSourceManager implements ServletContextListener {
    private static DataSource ds;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            ServletContext application = servletContextEvent.getServletContext();
            InputStream is = application.getResourceAsStream("WEB-INF/Druid-config.properties");
            Properties properties = new Properties();
            properties.load(is);
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
    public static DataSource getDs(){
        return ds;
    }


}

