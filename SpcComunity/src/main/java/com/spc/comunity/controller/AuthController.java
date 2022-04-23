package com.spc.comunity.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import com.google.gson.Gson;

@RequestMapping("/auth")
@RestController
public class AuthController {
	
	@GetMapping("/naver/token")
	public String NaverLogin(HttpServletRequest req) {
		String token = req.getParameter("token");
		String header = "Bearer " + token;
		String apiURL = "https://openapi.naver.com/v1/nid/me";
		WebClient webClient = WebClient.builder()
				.baseUrl(apiURL)
				.defaultHeader("Authorization", header)
				.build();
		
		String json = webClient.get().retrieve().bodyToMono(String.class).block();
		Object obj = new Gson().fromJson(json, Object.class);
		Map<String, Object> map = new HashMap<>();
		map = (Map)((Map)obj).get("response");
		
		
		return new Gson().toJson(map);
	}

}
