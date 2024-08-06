package com.psf.ex01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app")
public class Ex01Application {

	@GetMapping("/{senha}")
	public String fazerLogin(@PathVariable String senha) {
		String senhaCorreta = "senha123";

		if (!senha.equals(senhaCorreta)) {
			return "Entrada não autorizada";
		}

		return "Entrada autorizada";
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
	}

}
