package by.topolev.network.web.fasad;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import by.topolev.network.config.ConfigClass;
@Component
public class ProfileFasadImpl implements ProfileFasad {
	private String directorySaveImage = ConfigClass.DEFAULT_PATH_RESOURCES + "upload/";
	
	@Override
	public String uploadPhoto(MultipartFile mpf) throws IOException {
		String mimeFile = mpf.getContentType().split("\\/")[0];
		String namePathImage;
		if (mpf !=null){
			if (!mimeFile.equals("image")) {
				throw new IOException();
			}
			String newNameFile = getUniqueFileName(mpf.getOriginalFilename());
			File newFile = new File(directorySaveImage + newNameFile);
			byte[] contentFile = null;
			newFile.createNewFile();
			contentFile = mpf.getBytes();
			OutputStream out = new FileOutputStream(newFile);
			try {
				out.write(contentFile);
				namePathImage = newFile.getName();
				return namePathImage;
			} finally {
				out.close();
			}
		} else throw new IOException();
	}
	
	@Override
	public byte[] getImage(String fileName) throws IOException{
		File file = new File(directorySaveImage + fileName);
		byte[] content = null;
		InputStream in = new FileInputStream(file);
		content = IOUtils.toByteArray(in);
		return content;
	}
	
	@Override
	public  String cropPhoto(String fileName, int x1, int y1, int width, int height, int widthScaleImg) throws IOException{
		File fileCurrentImage = new File(directorySaveImage + fileName);
		File fileCropImage = new File(directorySaveImage + getUniqueFileName(fileName));
		
		BufferedImage image = ImageIO.read(fileCurrentImage);
		if (width == 0 || height == 0){
			width = image.getWidth();
			widthScaleImg = width;
			height = image.getHeight();
			x1=0;
			y1=0;
		}
		float scale = (float)image.getWidth()/widthScaleImg;
		int scopeX1 = (int) (x1*scale);
		int scopeY1 = (int) (y1*scale);
		int scopeWidth = (int) (width*scale);
		int scopeHeight = (int) (height*scale);
		image = image.getSubimage( scopeX1,  scopeY1, scopeWidth, scopeHeight);
		ImageIO.write(image, "jpg", fileCropImage);	
		return fileCropImage.getName();
	}
	
	
	/*REmove to FACAD*/
	public String getExpansionFile(String fileName){
		String ext = fileName.split("\\.")[1];
		return ext;
	}
	public String getUniqueFileName(String fileName){
		String exp = getExpansionFile(fileName);
		String uniqueFileName = UUID.randomUUID().toString().replaceAll("-","") + "." + exp;
		return uniqueFileName;
	}
	
}
