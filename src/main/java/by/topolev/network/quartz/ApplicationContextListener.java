package by.topolev.network.quartz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageCleanUpJob.class);

    @Resource(name = "defaultSpringBeanJobFactory")
    private DefaultSpringBeanJobFactory springBeanJobFactory;

    @Resource(name = "scheduler")
    private SchedulerFactoryBean schedulerFactory;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        ApplicationContext applicationContext = event.getApplicationContext();
        if(isParentContext(applicationContext)) {
            LOGGER.info("REFRESH parent context");
        }
    }

    private boolean isParentContext(ApplicationContext applicationContext) {
        return applicationContext != null && applicationContext.getParent() == null;
    }


}
