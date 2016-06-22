package by.topolev.network.web.controller;

import java.io.IOException;
import java.net.HttpURLConnection;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.jcabi.http.Request;
import com.jcabi.http.request.ApacheRequest;
import com.jcabi.http.request.JdkRequest;
import com.jcabi.http.response.RestResponse;

@Controller
public class TestController {

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String testMethod() throws IOException {
		System.out.println("TEST");
		String html = new JdkRequest("https://www.google.com").fetch().body();
				  
		System.out.println(html);
		return "test";
	}
}
