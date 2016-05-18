package by.topolev.network.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import by.topolev.network.config.ConfigClass;
import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.service.CatalogService;

@Controller
public class CalculateController {
	@Autowired
	private CatalogService catalogService;

	@RequestMapping(value = "/calculate", method = RequestMethod.GET)
	public String showFormInputData() {
		return "calculate";
	}

	public class WrapJSON {
		public Collection<? extends CatalogDTO> table;
		public String textError;
	};

	/*
	 * The tutorial see in
	 * http://blog.netgloo.com/2015/02/08/spring-boot-file-upload-with-ajax/
	 */
	@RequestMapping(value = "/calculate/download", method = RequestMethod.POST)
	public @ResponseBody Object downloadCatalog(@RequestParam("file") MultipartFile file) throws IOException {

		WrapJSON result = new WrapJSON();
		if (file.isEmpty()) {
			result.textError = "You failed to upload file";
			return result;
		}
		result.table = catalogService.loadCatalog(file.getInputStream());
		return result;
	}

	@RequestMapping(value = "/calculate/save", method = RequestMethod.POST)
	@ResponseBody
	public String prepareCSVFile(@RequestBody CatalogData data) {
		File file = catalogService.getFileCatalogInCSV(data);
		return file.getName();
	}

	@RequestMapping(value = "/calculate/save/{file}", method = RequestMethod.GET)
	public void downloadCSVFile(@PathVariable("file") String pathFile, HttpServletResponse response) {
		File file = new File(ConfigClass.DEFAULT_PATH_CSV_FILE + pathFile + ".csv");
		if (file.exists()) System.out.println("FILE EXXISTS");
		System.out.println(ConfigClass.DEFAULT_PATH_CSV_FILE + pathFile);
		try {
			InputStream is = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			try{
				FileCopyUtils.copy(is, response.getOutputStream());
			} finally{
				response.flushBuffer();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 

	}

}
