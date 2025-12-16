package com.JCservicios.literalura;

import com.JCservicios.literalura.principal.Principal;
import com.JCservicios.literalura.service.AutorService;
import com.JCservicios.literalura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LiteraluraApplication implements CommandLineRunner {

    @Autowired
    private AutorService autorService;

    @Autowired
    private LibroService librosService;

	public static void main(String[] args) {
		SpringApplication.run(LiteraluraApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {

        Principal principal = new Principal(autorService,librosService);
        principal.mostarMenu();

    }
}
