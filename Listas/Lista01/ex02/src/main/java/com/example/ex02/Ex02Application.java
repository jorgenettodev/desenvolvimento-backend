package com.example.ex02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app")
public class Ex02Application {

	@GetMapping("/{quantidadeKilometros}")
	static public String converterKilometros(@PathVariable String quantidadeKilometros) {

		double quantidadeKilometrosDouble = Double.parseDouble(quantidadeKilometros);

		double precoFinal = quantidadeKilometrosDouble * 25;
		
		// coloquei esse %.1f para que ele retorne apenas uma casa decimal.
		return String.format("O preco final de sua expedicao eh: %.1f pratas", precoFinal);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Ex02Application.class, args);
	}

}
