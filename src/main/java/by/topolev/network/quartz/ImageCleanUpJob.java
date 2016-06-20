package by.topolev.network.quartz;

import java.util.Date;
import java.util.List;

import by.topolev.network.web.controller.ProfileUserController;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.domain.UrlImage;
import by.topolev.network.service.ImageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import sun.awt.dnd.SunDragSourceContextPeer;

import javax.annotation.Resource;

public class ImageCleanUpJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageCleanUpJob.class);

    @Resource(name = "imageService")
    private ImageService imageService;
	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		System.out.println("START");
        if(imageService != null) {
            LOGGER.info("The imageService is injected successfully!");
        } else {
            LOGGER.info("The imageService is not injected!");
        }
//		JobDataMap map = jobContext.getMergedJobDataMap();
//		UrlImageDao urlImageDao = (UrlImageDao) map.get("urlImageDao");
//		ImageService imageService = (ImageService) map.get("imageService");
//		int maxTimeExcitingUnusingUrlImage = (int) map.get("maxTimeExcitingUnusingUrlImage");
//		System.out.println(maxTimeExcitingUnusingUrlImage);
//		if (urlImageDao !=null){
//			List<UrlImage> list = urlImageDao.findAll();
//			for (UrlImage urlImage : list){
//
//				if ((urlImage.isMarkUsing() == false) &&
//						((new Date()).getTime()-urlImage.getDataCreate().getTime() > maxTimeExcitingUnusingUrlImage)){
//					imageService.deleteImage(urlImage.getUrlImage());
//				}
//			}
//		}
	}
	

	
}
