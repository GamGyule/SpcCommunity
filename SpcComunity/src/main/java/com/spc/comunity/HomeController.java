package com.spc.comunity;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@RequestMapping("/api/hi")
	public String Hi() {
		return "Backend > hi";
	}

}
