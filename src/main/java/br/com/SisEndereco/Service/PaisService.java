package br.com.SisEndereco.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.SisEndereco.Domain.Pais;
import br.com.SisEndereco.Repository.PaisRepository;
import br.com.SisEndereco.Service.Exceptions.ObjectNotFoundException;

@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;

	public Pais findById(Integer id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}

	public ArrayList<Pais> findByNomePortuguesContaining(Pais paisPesquisa) {

		ArrayList<Pais> paises = paisRepository.findByNomePortuguesContaining(paisPesquisa.getNomePortugues());
		return paises;
	}
}