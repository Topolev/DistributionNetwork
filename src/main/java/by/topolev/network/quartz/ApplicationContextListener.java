package by.topolev.network.quartz;

import javax.annotation.Resource;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;
@Component
public class ApplicationContextListener implements ApplicationListener<ContextRefreshedEvent> {

	private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationContextListener.class);
	
	@Resource
	private SchedulerFactoryBean schedulerFactory;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (isParentContext(event.getApplicationContext())) {
			scheduleImageCleanUpJob();
			scheduleNotificationMsg4InactiveUserJob();
		}
	}
	
	private void scheduleNotificationMsg4InactiveUserJob(){
		LOGGER.debug("Starting SendMessageUnactiveUserJob");
		try{
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		JobDetail job = JobBuilder.newJob(NotificationMsg4InactiveUserJob.class).build();
		ScheduleBuilder sb = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15).repeatForever();
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(sb).build();
		
		scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e){
			LOGGER.debug("Cannot run SendMessageUnactiveUserJob.", e);
			LOGGER.error("Cannot run SendMessageUnactiveUserJob.");
		}
	}
	
	private void scheduleImageCleanUpJob() {
		LOGGER.debug("Starting ImageCleanUpJob");
		try{
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		JobDetail job = JobBuilder.newJob(ImageCleanUpJob.class).build();
		ScheduleBuilder sb = SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15).repeatForever();
		Trigger trigger = TriggerBuilder.newTrigger().withSchedule(sb).build();
		
		scheduler.scheduleJob(job, trigger);
		} catch (SchedulerException e){
			LOGGER.debug("Cannot run ImageCleanUpJob.", e);
			LOGGER.error("Cannot run ImageCleanUpJob.");
		}
	}
	
	
	private boolean isParentContext(ApplicationContext applicationContext) {
		return applicationContext != null && applicationContext.getParent() == null;
	}

}
