package by.topolev.network.quartz;

import java.util.HashMap;
import java.util.Map;

import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.ScheduleBuilder;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.core.jmx.JobDataMapSupport;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.service.ImageService;

//@Component
public class InitQuartz implements ApplicationListener<ContextRefreshedEvent>{
	private final static Logger LOGGER =LoggerFactory.getLogger(InitQuartz.class);
	private static final int MAX_TIME_EXCITING_UNUSING_URL_IMAGE = 10000;
	@Autowired
	private UrlImageDao urlImageDao;
	@Autowired
	private ImageService imgaeService;
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (event.getApplicationContext().getParent() == null){
			System.out.println("LOAD QUARTZ");
			SchedulerFactory sf = new StdSchedulerFactory();
			try {
				Scheduler schedlure = sf.getScheduler();
				schedlure.start();
				
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("urlImageDao", urlImageDao);
				map.put("imageService", imgaeService);
				map.put("maxTimeExcitingUnusingUrlImage", MAX_TIME_EXCITING_UNUSING_URL_IMAGE);
				
				JobDataMap jobDataMap = JobDataMapSupport.newJobDataMap(map);
				
				JobDetail job = JobBuilder
						.newJob(ImageCleanUpJob.class)
						.usingJobData(jobDataMap)
						.build();
				
				ScheduleBuilder sb = SimpleScheduleBuilder
						.simpleSchedule()
						.withIntervalInSeconds(15)
						.repeatForever();
				
				Trigger trigger = TriggerBuilder
						.newTrigger()
						.withSchedule(sb)
						.build();
				
				schedlure.scheduleJob(job, trigger);
				
			} catch (SchedulerException e) {
				LOGGER.info("Can't load quartz", e);
			}
		}
	}

}
