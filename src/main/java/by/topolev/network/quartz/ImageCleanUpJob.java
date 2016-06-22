package by.topolev.network.quartz;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.domain.UrlImage;
import by.topolev.network.service.ImageService;

public class ImageCleanUpJob implements Job {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImageCleanUpJob.class);

    @Resource
    private ImageService imageService;
    @Resource
    private UrlImageDao urlImageDao;
    
    private int maxTimeExcitingUnusingUrlImage = 60000;
	
	@Override
	public void execute(JobExecutionContext jobContext) throws JobExecutionException {
		LOGGER.debug("Start job ImageCleanUpJob");
        if(imageService != null) {
        	List<UrlImage> list = urlImageDao.findAll();
        	for (UrlImage urlImage : list){
        		if ((urlImage.isMarkUsing() == false) &&
       				((new Date()).getTime()-urlImage.getDataCreate().getTime() > maxTimeExcitingUnusingUrlImage)){
        			imageService.deleteImage(urlImage.getUrlImage());
        		}
        	}
        } else {
            LOGGER.info("The imageService is not injected!");
        }
	}
	
}
