package com.example.ex01;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/app/ilhas-de-calor")
public class Ex01Application {

	static public List<IlhaDeCalor> ilhasDeCalor = new ArrayList<>();

	@GetMapping
	public List<IlhaDeCalor> listarIlhasDeCalor() {
		return ilhasDeCalor;
	}

	@PostMapping
	public String adicionarIlhaDeCalor(@RequestBody IlhaDeCalor ilha) {
		// IlhaDeCalor novaIlha = (IlhaDeCalor) ilha;
		ilhasDeCalor.add(ilha);
		return String.format("Ilha de calor %s adicionada com sucesso.", ilha.getBairro());
	}

	public static void main(String[] args) {
		SpringApplication.run(Ex01Application.class, args);
		// ilhasDeCalor.add(new IlhaDeCalor(1, "Restinga", "Sul"));
	}

}
