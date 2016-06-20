package by.topolev.network.quartz;

import javax.servlet.ServletContext;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import by.topolev.network.dao.UrlImageDao;

public class JobClearUnusingUrlImage implements Job {
	private static final String APPLICATION_CONTEXT_KEY = "applicationContext";

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		try {
		    ApplicationContext appCtx = getApplicationContext(context);

	        WebApplicationContext webCtx = null;
	        ServletContext srvCtx = null;
	        if (appCtx instanceof WebApplicationContext){
	             webCtx = (WebApplicationContext) appCtx;
	             srvCtx = webCtx.getServletContext();
	             srvCtx.setAttribute("foo", "bar");
	        }
	        
			UrlImageDao urlImageDao= (UrlImageDao)srvCtx.getBean("urlImageDao");
			if (urlImageDao !=null){
				System.out.println("This bean is excited");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private ApplicationContext getApplicationContext(JobExecutionContext context) throws Exception {
		ApplicationContext appCtx = null;
		appCtx = (ApplicationContext) context.getScheduler().getContext().get(APPLICATION_CONTEXT_KEY);
		if (appCtx == null) {
			throw new JobExecutionException("No application context available in scheduler context for key \""
					+ APPLICATION_CONTEXT_KEY + "\"");
		}
		return appCtx;
	}

}
