package com.utfpr.musical_api.backend_musical_api;

import com.utfpr.musical_api.backend_musical_api.config.SpringDataConfig;
import com.utfpr.musical_api.backend_musical_api.entity.Categoria;
import com.utfpr.musical_api.backend_musical_api.entity.Musica;
import com.utfpr.musical_api.backend_musical_api.exceptions.MusicaBusinessException;
import com.utfpr.musical_api.backend_musical_api.service.MusicaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {
		BackendMusicalApiApplication.class,
})
@ActiveProfiles("test")
class BackendMusicalApiApplicationTests {
	@Autowired
	private MusicaService musicaService;

	@Test
	void contextLoads() {
		Musica musica = new Musica();
		musica.setTitulo("Musical");
		musica.setDuracao(40);

		Categoria categoria = new Categoria();
		categoria.setNome("Musical");

		try {
			musicaService.salvar(musica, categoria);
		} catch (MusicaBusinessException e) {
			System.out.println(e.getMessage());
		}
	}
}
