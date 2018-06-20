package br.com.SisEndereco;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.com.SisEndereco.Domain.Pais;
import br.com.SisEndereco.Repository.PaisRepository;

@SpringBootApplication
public class SisEnderecoApplication implements CommandLineRunner {
	// private static final Logger log =
	// LoggerFactory.getLogger(SisEnderecoApplication.class);
	@Autowired
	private PaisRepository repoPais;

	public static void main(String[] args) {
		SpringApplication.run(SisEnderecoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Alguns objetos para salvar no BD
		 */
		Pais pais4 = new Pais(0, 4, "AF", "AFG", "Afeganistão", "Afghanistan", "Afghanistan", "93", true);
		Pais pais8 = new Pais(0, 8, "AL", "ALB", "Albânia", "Albania", "Albanie", "355", true);
		Pais pais12 = new Pais(0, 12, "DZ", "DZA", "Argélia", "Algeria", "Algérie", "213", true);
		Pais pais16 = new Pais(0, 16, "AS", "ASM", "Samoa Americana", "American Samoa", "", "1", true);
		Pais pais710 = new Pais(0, 710, "ZA", "ZAF", "África do Sul", "South-Africa", "Afrique Du Sud", "27", true);
		Pais pais276 = new Pais(0, 276, "DE", "DEU", "Alemanha", "Germany", "Allemagne", "49", true);
		Pais pais20 = new Pais(0, 20, "AD", "AND", "Andorra", "Andorra", "Andorre", "376", true);
		ArrayList<Pais> paises = new ArrayList<Pais>(
				Arrays.asList(pais4, pais8, pais12, pais16, pais710, pais276, pais20));
		for (Pais pais : paises) {
			System.out.println(pais);
		}
		repoPais.saveAll(paises);

		// /*
		// * Listando todos os Paises
		// */
		// log.info("Paises encontrados com findAll():");
		// log.info("---------------------------------");
		// for (Pais pais : repoPais.findAll()) {
		// log.info(pais.toString());
		// }
		// log.info("");
		//
		// /*
		// * Listando pais com id =1
		// */
		// repoPais.findById(1).ifPresent(pais -> {
		// log.info("Pais encontrado com findById(1):");
		// log.info("--------------------------------");
		// log.info(pais.toString());
		// log.info("");
		// });
		//
		/*
		 * Listando todos os Paises com a letra B
		 */
		// log.info("Paises encontrados com findLike('b'):");
		// log.info("--------------------------------------------");
		// repoPais.findByNomePortugues("Andorra").forEach(paisB -> {
		// log.info(paisB.toString());
		// });
		// log.info("");
	};
}
