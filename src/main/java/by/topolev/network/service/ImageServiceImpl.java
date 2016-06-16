package by.topolev.network.service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.transaction.Transactional;

import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.web.multipart.MultipartFile;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.dao.UrlImageDao;
import by.topolev.network.domain.UrlImage;
import by.topolev.network.web.fasad.ExceptionNotSupportTypeOfUploadFile;
import by.topolev.network.web.fasad.ExceptionRequestHasNotFile;

@Service
public class ImageServiceImpl implements ImageService {
	private String directorySaveImage = ConfigClass.DEFAULT_PATH_RESOURCES + "upload/";
	private static final Logger LOGGER = LoggerFactory.getLogger(ImageServiceImpl.class);

	@Autowired
	private UrlImageDao urlImageDao;

	@Override
	public String uploadPhoto(MultipartFile mpf)
			throws ExceptionNotSupportTypeOfUploadFile, IOException, ExceptionRequestHasNotFile {
		LOGGER.debug("Upload new image");
		String mimeFile = mpf.getContentType().split("\\/")[0];
		String namePathImage;
		if (mpf != null) {
			if (!mimeFile.equals("image")) {
				LOGGER.warn(String.format(
						"Attemp to upload file with unsupported type %s. Supported type is only \'image\'", mimeFile));
				throw new ExceptionNotSupportTypeOfUploadFile();
			}
			String uniqueNameImage = null;
			File fileImage = null;
			do {
				uniqueNameImage = getUniqueFileName(mpf.getOriginalFilename());
				fileImage = new File(directorySaveImage + uniqueNameImage);
			} while (fileImage.exists());
			try {
				fileImage.createNewFile();
			} catch (IOException e) {
				LOGGER.warn(String.format("Can not create new file %s", fileImage.getAbsolutePath()), e);
				throw new IOException();
			}
			byte[] contentFile = null;
			try {
				contentFile = mpf.getBytes();
				OutputStream out = new FileOutputStream(fileImage);
				try {
					out.write(contentFile);
				} finally {
					out.close();
				}
				namePathImage = fileImage.getName();
				createUrlImageInDB(namePathImage, false);
				LOGGER.debug(String.format("Success upload new image file %s", namePathImage));
				return namePathImage;
			} catch (IOException e) {
				LOGGER.warn("Problems with create new image file", e);
				throw new IOException();
			}
		} else {
			LOGGER.warn("Current request hasn't multipart file.");
			throw new ExceptionRequestHasNotFile();
		}
	}

	@Override
	public void createUrlImageInDB(String urlImage, boolean markUsing) {
		UrlImage imageStore = new UrlImage();
		imageStore.setUrlImage(urlImage);
		imageStore.setMarkUsing(markUsing);
		imageStore.setDataCreate(new Date());
		try {
			urlImageDao.create(imageStore);
		} catch (Exception e) {
			LOGGER.warn(String.format("Unable to save url image with name %s in DB", urlImage), e);
		}
	}

	@Override
	public void updateUrlImageInDb(String url, boolean markUsing) {
		UrlImage urlImage = urlImageDao.findByUrl(url);
		try {
			urlImage.setMarkUsing(markUsing);
			urlImageDao.update(urlImage);
		} catch (Exception e) {
			LOGGER.warn(String.format("Unable to change mark using for image %s", url));
		}
	}

	@Override
	@org.springframework.transaction.annotation.Transactional(propagation=Propagation.REQUIRED)
	public void deleteImage(String url) {
		File image = new File(directorySaveImage + url);
		if (image.exists()) {
			image.delete();
			UrlImage urlImage = urlImageDao.findByUrl(url);
			if (urlImage != null) {
				try {
					urlImageDao.delete(urlImage);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				LOGGER.info("Url image file with name %S in DB not excites", urlImage);
			}
		} else {
			LOGGER.info(String.format("Image file with name %s isn't excited", url));
		}

	}

	@Override
	public UrlImage getUrlImage(String url) {
		return urlImageDao.findByUrl(url);
	}

	@Override
	public byte[] getImage(String fileName) throws IOException {
		File file = new File(directorySaveImage + fileName);
		byte[] content = null;
		try {
			InputStream in = new FileInputStream(file);
			content = IOUtils.toByteArray(in);
		} catch (IOException e) {
			LOGGER.info(String.format("Problem gettig image: %s", file.getAbsolutePath()));
			throw new IOException();
		}
		return content;
	}

	@Override
	public String cropPhoto(String fileName, int x1, int y1, int width, int height, int widthScaleImg)
			throws IOException {
		File fileCurrentImage = new File(directorySaveImage + fileName);
		File fileCropImage = new File(directorySaveImage + getUniqueFileName(fileName));

		BufferedImage image = null;
		try {
			image = ImageIO.read(fileCurrentImage);
		} catch (IOException e) {
			LOGGER.info(String.format("Image for cropping with name %s not excited", fileName));
			throw new IOException();
		}
		if (width == 0 || height == 0) {
			width = image.getWidth();
			widthScaleImg = width;
			height = image.getHeight();
			x1 = 0;
			y1 = 0;
		}
		float scale = (float) image.getWidth() / widthScaleImg;
		int scopeX1 = (int) (x1 * scale);
		int scopeY1 = (int) (y1 * scale);
		int scopeWidth = (int) (width * scale);
		int scopeHeight = (int) (height * scale);
		image = image.getSubimage(scopeX1, scopeY1, scopeWidth, scopeHeight);
		try {
			ImageIO.write(image, "jpg", fileCropImage);
		} catch (IOException e) {
			LOGGER.info(String.format("Problem wihh save crop image with name \"%s\"", fileCropImage.getName()));
			throw new IOException();
		}
		createUrlImageInDB(fileCropImage.getName(), false);
		deleteImage(fileCurrentImage.getName());
		return fileCropImage.getName();
	}

	public String getExpansionFile(String fileName) {
		String ext = fileName.split("\\.")[1];
		return ext;
	}

	public String getUniqueFileName(String fileName) {
		String exp = getExpansionFile(fileName);
		String uniqueFileName = UUID.randomUUID().toString().replaceAll("-", "") + "." + exp;
		return uniqueFileName;
	}
}
