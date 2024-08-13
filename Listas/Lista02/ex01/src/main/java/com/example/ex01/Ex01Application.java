package com.example.ex01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app")
public class Ex01Application {

	static public List<IlhaDeCalor> ilhasDeCalor = new ArrayList<>();

	@GetMapping
	public List<IlhaDeCalor> getIlhasDeCalor() {
		return ilhasDeCalor;
	}

	@PostMapping
	public String post() {
		return "Esta eh a rota Post";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
		ilhasDeCalor.add(new IlhaDeCalor(1, "Restinga", "Sul"));
	}

}
