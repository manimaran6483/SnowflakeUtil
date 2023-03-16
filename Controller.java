package com.client.app;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bsc.snow.flake.model.Response;
import com.bsc.snow.flake.service.SnowflakeTemplate;

@RestController
public class Controller {

	@Autowired
	private SnowflakeTemplate template;
	
	@GetMapping("/select")
	public String testSelect() {

		LinkedHashMap<String, String> properties = new LinkedHashMap<>();
		
		properties.put("1", "AAA");
		
		Response res = template.query("Select * from EMPLOYEE WHERE name =?", properties);
		
		return res.toString();
		
	}
}
