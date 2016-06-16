package by.topolev.network.service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import by.topolev.network.domain.UrlImage;
import by.topolev.network.web.fasad.ExceptionNotSupportTypeOfUploadFile;
import by.topolev.network.web.fasad.ExceptionRequestHasNotFile;

public interface ImageService {
	String uploadPhoto(MultipartFile mpf)
			throws ExceptionNotSupportTypeOfUploadFile, IOException, ExceptionRequestHasNotFile;

	byte[] getImage(String fileName) throws IOException;

	String cropPhoto(String fileName, int x1, int y1, int width, int height, int widthScaleImg) throws IOException;
	
	void createUrlImageInDB(String urlImage, boolean markUsing);
	
	void updateUrlImageInDb(String url, boolean markUsing);
	
	UrlImage getUrlImage(String url);
	
	void deleteImage(String url);

}
