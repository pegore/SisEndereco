package br.com.SisEndereco.Repository;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.SisEndereco.Domain.Pais;

@Repository
public interface PaisRepository extends CrudRepository<Pais, Integer> {
	ArrayList<Pais> findByNomePortuguesContaining(String nomePortugues);
	ArrayList<Pais> findByCodigoAlfa2Containing(String codigoAlfa2);

}
