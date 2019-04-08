package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
	
	@GetMapping
	public @ResponseBody String hello(@RequestParam(name="nome", required=true) String nome, String sobrenome) {
		return "Olá " + nome + " " + sobrenome;
	}
	
	@GetMapping("/soma")
	public @ResponseBody String soma(int a, int b) {
		return "Resposta=" + (a + b);
	}

}
