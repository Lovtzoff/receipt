package ru.clevertec.controller.listener;

import ru.clevertec.util.DBConnectionPool;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ServletListener implements ServletContextListener {

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        DBConnectionPool.INSTANCE.destroyPool();
    }
}
