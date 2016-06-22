package by.topolev.network.web.controller;

import javax.json.JsonArray;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.JsonResponse;

@Controller
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testMethod() throws Exception {
		System.out.println("TEST");
		String body= new JdkRequest("http://www.nbrb.by/API/ExRates/Currencies/1").fetch().as(JsonResponse.class).json().readObject().getString("Cur_Name");
		
		JsonArray array= new JdkRequest("http://www.nbrb.by/API/ExRates/Currencies").fetch().as(JsonResponse.class).json().readArray();
		for (int i=0; i<array.size();i++){
			System.out.println(array.getJsonObject(i).getString("Cur_Name"));
			
		}
		
				  
		/*System.out.println(body);*/
		return "test";
	}
}
