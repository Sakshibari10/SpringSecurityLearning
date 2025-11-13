package com.example.demo.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class SecurityController {

	@GetMapping("/admin")
	public String helloadmin()
	{
		
		return "hello sakshi";
	}
	
    @GetMapping("/user/hello")
	public String helloUser()
	{
		
		return "hello sakshi";
	}
	
    @GetMapping("/manager/hello")
	public String hellomanager()
	{
		
		return "hello sakshi";
	}
	
    @GetMapping("/customer/hello")
	public String hellocusmor()
	{
		
		return "hello sakshi";
	}
	
	
}
