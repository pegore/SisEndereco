package br.com.SisEndereco.Service;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.SisEndereco.Domain.Pais;
import br.com.SisEndereco.Repository.PaisRepository;
import br.com.SisEndereco.Service.Exceptions.DataIntegrityException;
import br.com.SisEndereco.Service.Exceptions.ObjectNotFoundException;

@Service
public class PaisService implements IService<Pais> {
	@Autowired
	private PaisRepository paisRepository;

	public Pais insert(Pais pais) {
		pais.setId(null);
		return paisRepository.save(pais);
	}

	public Pais update(Pais pais) {
		Pais novoPais = findById(pais.getId());
		novoPais.setNomePortugues(pais.getNomePortugues());
		return paisRepository.save(novoPais);
	}

	public String delete(Integer id) {
		findById(id);
		try {
			paisRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um País que possui Estados");
		}
		return "Inserido com Sucesso";
	}

	public Pais findById(Integer id) {
		Optional<Pais> pais = paisRepository.findById(id);
		return pais.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pais.class.getName()));
	}

	public List<Pais> findLike(Pais pais) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("ativo")
				.withStringMatcher(StringMatcher.CONTAINING);
		Example<Pais> exemplo = Example.of(pais, matcher);
		List<Pais> listaPaises = paisRepository.findAll(exemplo);
		return listaPaises;
	}

	public String uploadFile(MultipartFile arquivoUpload) {
		String retorno = null;
		BufferedReader arquivo = null;
		ArrayList<Pais> paises = new ArrayList<Pais>();
		try {
			String linha = "";
			arquivo = new BufferedReader(new FileReader(new File(arquivoUpload.getOriginalFilename())));
			while ((linha = arquivo.readLine()) != null) {
				if (linha.charAt(0) == 'D') {
					Pais pais = new Pais();
					pais.setCodigoAlfa2(linha.substring(1, 3));
					pais.setCodigoAlfa3(linha.substring(3, 6));
					pais.setNomePortugues(linha.substring(6, 78));
					pais.setNomeIngles(linha.substring(78, 150));
					pais.setNomeFrances(linha.substring(150, 222));
					paises.add(pais);
				}
			}
			arquivo.close();
			paisRepository.saveAll(paises);
			retorno = "Executado com sucesso";
		} catch (Exception e) {
			retorno = "Erro ao ler arquivo";
		}
		return retorno;

	}
}