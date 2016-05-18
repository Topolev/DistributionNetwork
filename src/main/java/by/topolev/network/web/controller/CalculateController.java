package by.topolev.network.web.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import by.topolev.network.data.catalog.sample.CatalogDTO;
import by.topolev.network.service.CatalogService;


@Controller
public class CalculateController {
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value="/calculate", method=RequestMethod.GET)
	public String showFormInputData(){
		return "calculate";
	}
	
	public class WrapJSON {
		public Collection<? extends CatalogDTO> table;
		public String textError; 
	};
	

	
	/*The tutorial see in http://blog.netgloo.com/2015/02/08/spring-boot-file-upload-with-ajax/*/
	@RequestMapping(value="/calculate/download", method = RequestMethod.POST)
	public @ResponseBody Object downloadCatalog(@RequestParam("file") MultipartFile file) throws IOException{
		
		WrapJSON result = new WrapJSON();
		if (file.isEmpty()){
			result.textError = "You failed to upload file";
			return result;
		}
		result.table = catalogService.loadCatalog(file.getInputStream());
		return result;
	}
	
	
	@RequestMapping(value="/calculate/save", method = RequestMethod.POST)
	@ResponseBody
	public String prepareCSVFile(@RequestBody CatalogData data){
		System.out.println("HERE");
		File file = new File("catalog.csv");
		try {
			if (!file.exists()){
				file.createNewFile();
			}
			System.out.println("01");
			PrintWriter out = new PrintWriter(file.getAbsoluteFile());
			try{
				out.println(catalogService.saveCatalogInCSV(data));
				System.out.println("02");
			} finally {
				out.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("03");
		System.out.println(file.getAbsolutePath());
		return file.getAbsolutePath();
	}
}
