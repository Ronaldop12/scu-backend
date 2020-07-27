package com.scu;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.scu.model.Usuario;
import com.scu.repositories.UsuarioRepository;

@SpringBootApplication
public class ScuBackendApplication implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ScuBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usuario = new Usuario(null, "Ronaldo", "Ronaldo", "12345");
		Usuario u = new Usuario(null, "João", "João", "12345");
		
		usuarioRepository.saveAll(Arrays.asList(usuario, u));
		
	}

}
