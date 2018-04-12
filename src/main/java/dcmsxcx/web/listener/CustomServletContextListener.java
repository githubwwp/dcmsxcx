package dcmsxcx.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.log4j.Logger;

public class CustomServletContextListener implements ServletContextListener {
    
    private Logger log = Logger.getLogger(this.getClass());
    

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log.info("---项目启动---");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log.info("---项目销毁---");
    }

}
