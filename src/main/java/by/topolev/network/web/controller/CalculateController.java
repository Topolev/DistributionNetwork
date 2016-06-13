package by.topolev.network.web.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collection;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import by.topolev.network.data.csv.InvalidCSVException;
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
	public @ResponseBody Object downloadCatalog(@RequestParam("nameClassTable") String nameClassEntity,
			@RequestParam("file") MultipartFile file) throws IOException {
		WrapJSON result = new WrapJSON();
		if (file.isEmpty()) {
			result.textError = "You failed to upload file";
			return result;
		}
		try {
			result.table = catalogService.loadCatalog(file.getInputStream(), nameClassEntity);
		} catch (InvalidCSVException e) {
			result.textError = "CSV file is invalid";
		}
		return result;
	}
	
	@RequestMapping(value = "/api/test", method=RequestMethod.GET)
	public @ResponseBody ResponseEntity<String> doSmth(@RequestParam("code") String code) {
		if("200".equals(code)) {
			ResponseEntity<String> responseEntity = new ResponseEntity<>("Hello, Vova", HttpStatus.OK);
			return responseEntity;
		} 
		if("400".equals(code)) {
			return new ResponseEntity<>("Goodbye, Vova", HttpStatus.BAD_REQUEST);
		}
		
		if("500".equals(code)) {
			return new ResponseEntity<>("Hello, Vova", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		//validatorStrategy.find(type).validate(value);
		
		/*
		 *
		 * 
		 * class UniqueLoginValidator implements Validator {
		 * 
		 * }
		 * 
		 * @Component
		  class SignUpValidatorStrategy implements ValidatorStrategy {
		  	@Resource
		  	private UniqueLoginValidator validator1;
		  	@Resource
		  	private FirstNameValidator validator2;
		  	@Resource
		  	private LoginValidator validator3;
		  	
		  	public Validator find(String type) {
		  	
		  		if("login".equals(type)) {
		  			return validator1;
		  		}
		  		
		  		return ...;
	  		}
	  	}
	  	
	  	@Component
	  	class ProfileValidatorStrategy implements ValidatorStrategy {
	  		@Resource
	  		private FirstNameValidator validator1;
	  		@Resource
	  		private BirthDateValidator validator2;
	  		@Resource
	  		private UserRoleValidator validator3;
	  		@Resource 
	  		private PermissionValidator validator4;
	  	
	  		public Validator find(String type) {
	  		
	  			return ...;
	  		}
	  	}
		  	
		 */
		return new ResponseEntity<>("Vova is created", HttpStatus.CREATED);
		
	}

	@RequestMapping(value = "/calculate/save", method = RequestMethod.POST)
	@ResponseBody
	public String prepareCSVFile(@RequestBody CatalogData data) {
		String nameFile = null;
		try {
			nameFile = catalogService.saveCatalogInCSV(data);
		} catch (InvalidCSVException e) {
			e.printStackTrace();
		}
		System.out.println(nameFile);
		return nameFile;
	}

	@RequestMapping(value = "/calculate/save/{file}", method = RequestMethod.GET)
	public void downloadCSVFile(@PathVariable("file") String pathFile, HttpServletResponse response) {
		File file = new File(ConfigClass.DEFAULT_PATH_CSV_FILE + pathFile + ".csv");
		if (file.exists())
			System.out.println("FILE EXXISTS");
		System.out.println(ConfigClass.DEFAULT_PATH_CSV_FILE + pathFile);
		try {
			InputStream is = new FileInputStream(file);
			response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
			try {
				FileCopyUtils.copy(is, response.getOutputStream());
			} finally {
				response.flushBuffer();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
