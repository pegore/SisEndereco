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

import br.com.SisEndereco.Domain.Estado;
import br.com.SisEndereco.Domain.Pais;
import br.com.SisEndereco.Repository.EstadoRepository;
import br.com.SisEndereco.Service.Exceptions.DataIntegrityException;
import br.com.SisEndereco.Service.Exceptions.ObjectNotFoundException;

@Service
public class EstadoService implements IService<Estado> {
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private PaisService paisService;

	public Estado insert(Estado estado) {
		estado.setId(null);
		return estadoRepository.save(estado);
	}

	public Estado update(Estado estado) {
		Estado novoestado = findById(estado.getId());
		novoestado.setNomeEstado(estado.getNomeEstado());
		return estadoRepository.save(novoestado);
	}

	public String delete(Integer id) {
		findById(id);
		try {
			estadoRepository.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir um Estado que possui Municipios");
		}
		return "Excluído com Sucesso";
	}

	public Estado findById(Integer id) {
		Optional<Estado> estado = estadoRepository.findById(id);
		return estado.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}

	public List<Estado> findLike(Estado estado) {
		ExampleMatcher matcher = ExampleMatcher.matching().withIgnorePaths("ativo")
				.withStringMatcher(StringMatcher.CONTAINING);
		Example<Estado> exemplo = Example.of(estado, matcher);
		List<Estado> listaestadoes = estadoRepository.findAll(exemplo);
		return listaestadoes;
	}

	public String uploadFile(MultipartFile arquivoUpload) {
		String retorno = null;
		BufferedReader arquivo = null;
		ArrayList<Estado> estados = new ArrayList<Estado>();
		try {
			String linha = "";
			arquivo = new BufferedReader(new FileReader(new File(arquivoUpload.getOriginalFilename())));
			while ((linha = arquivo.readLine()) != null) {
				if (linha.charAt(0) == 'D') {
					Estado estado = new Estado();
					Pais paisPesquisa = new Pais();
					paisPesquisa.setCodigoAlfa2(linha.substring(2, 3));
					estado.setPais(paisService.findLike(paisPesquisa).get(0));
					estado.setSigla(linha.substring(4, 5));
					estado.setNomeEstado(linha.substring(10, 81));
					estados.add(estado);
				}
			}
			arquivo.close();
			estadoRepository.saveAll(estados);
			retorno = "Executado com sucesso";
		} catch (Exception e) {
			retorno = "Erro ao ler arquivo";
		}
		return retorno;

	}
}