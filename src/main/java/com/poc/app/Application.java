package com.poc.app;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {
	
	private boolean healthy = true;
	
    @RequestMapping("/")
    public Map<String, String> hello() {
    	Map<String, String> map = new HashMap<>();
        map.put("message", "Hello World!!");
        
        Map<String, String> mapEnvVariables = System.getenv();
        mapEnvVariables.forEach((key,value) ->
        	map.put(key, value)
        );
        
        return map;
    }
    
    @RequestMapping("/version")
    public Map<String, String> version() {
    	Map<String, String> map = new HashMap<>();
        map.put("version", "0.0.2");
        return map;
    }
    
    @RequestMapping("/health")
    public Map<String, String> health() {
    	
    	if (healthy) {
    		Map<String, String> map = new HashMap<>();
            map.put("status", "UP");
            return map;
            
    	} else {
    		throw new IllegalStateException("API is currently down");
    	}
    }
    
    @PostMapping("/healthStatus")
    public void setHealthStatus(@RequestBody boolean healthStatus) {
    	this.healthy = healthStatus;
    }
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
