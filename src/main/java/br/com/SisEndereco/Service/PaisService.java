package br.com.SisEndereco.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.com.SisEndereco.Domain.Pais;
import br.com.SisEndereco.Repository.PaisRepository;
import br.com.SisEndereco.Service.Exceptions.DataIntegrityException;
import br.com.SisEndereco.Service.Exceptions.ObjectNotFoundException;

@Service
public class PaisService {
	@Autowired
	private PaisRepository paisRepository;

	/**
	 * Inserção de um novo pais no BD
	 * 
	 * @param pais
	 * @return
	 */
	public Pais insert(Pais pais) {
		pais.setId(null);
		return paisRepository.save(pais);
	}

	/**
	 * Atualização de um país no BD
	 * 
	 * @param pais
	 * @return
	 */
	public Pais update(Pais pais) {
		Pais novoPais = findById(pais.getId());
		updateData(novoPais, pais);
		return paisRepository.save(novoPais);
	}

	private void updateData(Pais novoPais, Pais pais) {
		novoPais.setNomePortugues(pais.getNomePortugues());
	}

	/**
	 * Remoção de um País do BD
	 * 
	 * @param id
	 */
	public void delete(Integer id) {
		findById(id);
		try {
			paisRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um País que possui Estados");
		}
	}

	/**
	 * Busca um único País por Id no BD
	 * 
	 * @param id
	 * @return
	 */
	public Pais findById(Integer id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}

	/**
	 * Retorna um alista de paises do bd de acordo com os parametros passado por
	 * referencia
	 * 
	 * @param pais
	 * @param campoPesquisa
	 * @return
	 */
	public List<Pais> findPais(Pais pais) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("ativo").withStringMatcher(StringMatcher.CONTAINING);
//		
		Example<Pais> exemplo = Example.of(pais, matcher);
		List<Pais> listaPaises = paisRepository.findAll(exemplo);
		return listaPaises;
	}
}