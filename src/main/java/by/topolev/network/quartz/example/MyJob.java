package by.topolev.network.quartz.example;

import java.util.List;

import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.core.jmx.QuartzSchedulerMBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.domain.UrlImage;
import by.topolev.network.service.ImageService;

public class MyJob extends QuartzJobBean {
	@Autowired
	private UrlImageDao urlImageDao;
	@Autowired
	private ImageService imageService;
	private static int count;

	@Override
	protected void executeInternal(JobExecutionContext jobContext) throws JobExecutionException {
		System.out.println("--------------------------------------------------------------------");
		System.out.println("MyJob start: " + jobContext.getFireTime());
		JobDetail jobDetail = jobContext.getJobDetail();
		MyJobHelper jobHelper = (MyJobHelper) jobDetail.getJobDataMap().get("jobState");
		System.out.println("Example name is: " + jobHelper.getSomeStr());
		System.out.println("MyJob end: " + jobContext.getJobRunTime() + ", key: " + jobDetail.getKey());
		System.out.println("MyJob next scheduled time: " + jobContext.getNextFireTime());
		System.out.println("--------------------------------------------------------------------");

		count++;
		System.out.println("Job count " + count);

		ILatch latch = (ILatch) jobDetail.getJobDataMap().get("jobLatch");
		if (latch != null) {
			latch.countDown();
			System.out.println("Job executed, release latch");
		}
	}

}
