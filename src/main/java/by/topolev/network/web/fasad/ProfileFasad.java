package by.topolev.network.web.fasad;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

public interface ProfileFasad {
	String uploadPhoto(MultipartFile mpf) throws IOException;
	byte[] getImage(String fileName) throws IOException;
	String cropPhoto(String fileName, int x1, int y1, int width, int height, int widthScaleImg) throws IOException;
}
