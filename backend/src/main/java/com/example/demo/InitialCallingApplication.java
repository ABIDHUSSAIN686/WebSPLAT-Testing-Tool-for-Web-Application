package com.example.demo;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.StringTokenizer;
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.tomcat.util.json.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.openqa.selenium.WebDriver;

@CrossOrigin("*")
@RestController
public class InitialCallingApplication {

	// This function is used to send the string to frontend 
	@CrossOrigin
	@GetMapping("/")
	public String welcome(@RequestParam(value="name",defaultValue="springboot")String name) throws IOException {
		login();
		return String.format("Hello %s", name);
	}
	//This function recieve the URL from Frontend 
	@RequestMapping(method=RequestMethod.POST, value="/url")
	public void RecieveURL(@RequestBody String user) throws IOException { 

		user = user.replaceAll("[(){}]","");
		StringTokenizer st = new StringTokenizer(user); 
		String parm1="",parm2="",parm3="",parm4="";
		int count=0;
		while (st.hasMoreTokens()) {  
			StringTokenizer str1=new StringTokenizer(st.nextToken(":")); 
			if (count==1) {
				parm1=str1.nextToken(",");
			}
			if (count==2) {
				parm2=str1.nextToken(",");
			}
			if (count==3) {
				parm3=str1.nextToken(",");
			}
			if (count==4) {
				parm4=str1.nextToken(",");
			}
			count++;
		}
		System.out.println("Variant1 :"+parm1+"    Verion No :" + parm2+"    Variant2 :"+parm3+"    Verion No :" + parm4);
		Driver obj =new Driver();
		obj.starter();
	}

	public void login() {
		System.out.print("hello");
	}

}
