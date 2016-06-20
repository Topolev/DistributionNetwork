package by.topolev.network.quartz;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.topolev.network.service.ImageService;

public class ImageCleanUpJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageCleanUpJob.class);

    @Resource
    private ImageService imageService;
	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		System.out.println("START");
        /*if(imageService != null) {
       	List<UrlImage> list = urlImageDao.findAll();
        	for (UrlImage urlImage : list){
       
        		if ((urlImage.isMarkUsing() == false) &&
       				((new Date()).getTime()-urlImage.getDataCreate().getTime() > maxTimeExcitingUnusingUrlImage)){
        			imageService.deleteImage(urlImage.getUrlImage());
        		}
        	}
        } else {
            LOGGER.info("The imageService is not injected!");
        }*/
	}
	
}

//JobDataMap map = jobContext.getMergedJobDataMap();
//UrlImageDao urlImageDao = (UrlImageDao) map.get("urlImageDao");
//ImageService imageService = (ImageService) map.get("imageService");
//int maxTimeExcitingUnusingUrlImage = (int) map.get("maxTimeExcitingUnusingUrlImage");
//System.out.println(maxTimeExcitingUnusingUrlImage);
//if (urlImageDao !=null){
//	List<UrlImage> list = urlImageDao.findAll();
//	for (UrlImage urlImage : list){
//
//		if ((urlImage.isMarkUsing() == false) &&
//				((new Date()).getTime()-urlImage.getDataCreate().getTime() > maxTimeExcitingUnusingUrlImage)){
//			imageService.deleteImage(urlImage.getUrlImage());
//		}
//	}
//}