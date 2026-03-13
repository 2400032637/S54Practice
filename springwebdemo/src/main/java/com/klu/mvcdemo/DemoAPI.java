package com.klu.mvcdemo;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class DemoAPI {
	@GetMapping("/")
	public String home() {
		return "<h1>Welcome to SpringBoot MVC</h1>";
	}
	@GetMapping("/about")

	public String about(){
		return "<h1>Welcome to About Page<h1>";
	}
	@GetMapping("/contact")

	public String contact(){
		return "<h1>Welcome to contact Page<h1>";
	}
	@GetMapping("/contact/{email}")
	@PostMapping("/user")
	public ResponseEntity<?> userInfo(@RequestBody User u) 
	{
		if(u.getName()==null||u.getName().isBlank()) {
			return ResponseEntity.badRequest().body("User name must not be empty");
			
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(u);
	}
	@GetMapping("/page")
	public String pageInfo(@RequestParam String pageno,@RequestParam int pageid) {
		return "The Pageno is:"+pageno+"and the pageID is:"+pageid;
		
	}
	
}
