package com.k1x.j2ee.webiface.app;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class WebConnectorContextListener implements ServletContextListener {

    private CalculationThread myThread = null;

    public void contextInitialized(ServletContextEvent sce) {
        if ((myThread == null) || (!myThread.isAlive())) {
            myThread = new CalculationThread();
            myThread.start();
        }
    }

    public void contextDestroyed(ServletContextEvent sce){
        try {
            myThread.doShutdown();
            myThread.interrupt();
        } catch (Exception ex) {
        	ex.printStackTrace();
        }
    }
}
