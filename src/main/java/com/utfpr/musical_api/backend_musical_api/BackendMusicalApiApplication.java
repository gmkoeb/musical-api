package com.utfpr.musical_api.backend_musical_api;

import com.utfpr.musical_api.backend_musical_api.entity.Categoria;
import com.utfpr.musical_api.backend_musical_api.entity.Musica;
import com.utfpr.musical_api.backend_musical_api.exceptions.CategoriaBusinessException;
import com.utfpr.musical_api.backend_musical_api.exceptions.MusicaBusinessException;
import com.utfpr.musical_api.backend_musical_api.service.CategoriaService;
import com.utfpr.musical_api.backend_musical_api.service.MusicaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendMusicalApiApplication {
	private static final Logger log = LoggerFactory.getLogger(BackendMusicalApiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BackendMusicalApiApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(CategoriaService categoriaService, MusicaService musicaService) {
		return (args) -> {
			for(Musica m : musicaService.listar()) {
				log.info(m.toString());
				log.info(m.getTitulo());
				musicaService.remover(m);
			}

			for(Categoria c : categoriaService.listar()) {
				log.info(c.toString());
				categoriaService.remover(c);
			}

			Categoria categoria = new Categoria();
			categoria.setNome("Pop");
			categoria.setDescCategoria("A música pop é um género musical derivado do termo \"popular\", " +
					"conhecido pela sua acessibilidade e apelo comercial");
			try {
				categoriaService.salvar(categoria);
			} catch (CategoriaBusinessException e) {
				log.error(e.getMessage());
				log.error(e.getReason().toString());
			}
			Categoria categoria2 = new Categoria();
			categoria.setNome("Pop");
			try {
				categoriaService.salvar(categoria);
			} catch (CategoriaBusinessException e) {
				log.error(e.getMessage());
				log.error(e.getReason().toString());
			}
			Musica musica = new Musica();
			musica.setDuracao(250);
			musica.setTitulo("Billie Jean");
			try {
				musicaService.salvar(musica, categoria);
			} catch (MusicaBusinessException e) {
				log.error(e.getMessage());
				log.error(e.getReason().toString());
			}

			Musica musica2 = new Musica();
			musica2.setDuracao(250);
			musica2.setTitulo("Billie Jean");

			try {
				musicaService.salvar(musica2, categoria);
			} catch (MusicaBusinessException e) {
				log.error(e.getMessage());
				log.error(e.getReason().toString());
			}

			for(Musica m : musicaService.listar()) {
				log.info(m.toString());
				log.info(m.getTitulo());
				musicaService.remover(m);
			}

			for(Categoria c : categoriaService.listar()) {
				log.info(c.toString());
				categoriaService.remover(c);
			}
		};
	}
}
