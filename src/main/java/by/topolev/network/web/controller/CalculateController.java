package by.topolev.network.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class CalculateController {
	@RequestMapping(value="/calculate", method=RequestMethod.GET)
	public String showFormInputData(){
		return "calculate";
	}
	
	public class Dto {
		public Collection<Transform> table = new ArrayList<Transform>();
	};
	public class Transform{
		public Transform(String val){
			this.type = val;
		}
		public String type = "field";
		public String s = "100";
		public String uVN = "10";
		public String uNN = "0.4";
		public String uK = "10.5";
		public String pKZ = "100";
		public String pHH = "600";
	}
	
	/*The tutorial see in http://blog.netgloo.com/2015/02/08/spring-boot-file-upload-with-ajax/*/
	@RequestMapping(value="/calculate/download", method = RequestMethod.POST)
	public @ResponseBody Object downloadCatalog(@RequestParam("file") MultipartFile file) throws IOException{
		System.out.println("DOWNLOAD");
		System.out.println(file.getOriginalFilename());
		
		
		BufferedReader reader = null;
		
		reader = new BufferedReader(new InputStreamReader(file.getInputStream()));
		
		String line;
		while((line = reader.readLine()) != null){
			System.out.println(line);
		}
		

		
		
		
		
		Dto result = new Dto();
		result.table.add(new Transform("TM-100"));
		result.table.add(new Transform("TM-250"));
		result.table.add(new Transform("TM-1000"));
		return result;
	}
}
