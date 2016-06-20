package by.topolev.network.quartz;

import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.domain.UrlImage;
import by.topolev.network.service.ImageService;
import sun.awt.dnd.SunDragSourceContextPeer;

public class Job1 implements Job {
	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		System.out.println("START");
		JobDataMap map = jobContext.getMergedJobDataMap();
		UrlImageDao urlImageDao = (UrlImageDao) map.get("urlImageDao");
		ImageService imageService = (ImageService) map.get("imageService");
		int maxTimeExcitingUnusingUrlImage = (int) map.get("maxTimeExcitingUnusingUrlImage");
		System.out.println(maxTimeExcitingUnusingUrlImage);
		if (urlImageDao !=null){
			List<UrlImage> list = urlImageDao.findAll();
			for (UrlImage urlImage : list){
				
				if ((urlImage.isMarkUsing() == false) && 
						((new Date()).getTime()-urlImage.getDataCreate().getTime() > maxTimeExcitingUnusingUrlImage)){
					imageService.deleteImage(urlImage.getUrlImage());
				}
			}
		}
	}
	

	
}
