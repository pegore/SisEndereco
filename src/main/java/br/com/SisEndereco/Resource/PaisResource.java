package br.com.SisEndereco.Resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.com.SisEndereco.Domain.Pais;
import br.com.SisEndereco.Service.PaisService;

/**
 * * Classe REST para manipulação de objetos do tipo Pais<br>
 * <p>
 * URI para acesso: /paises
 * 
 * @author Lino Pegoretti
 *
 */
@RestController
@RequestMapping(value = "/paises")
public class PaisResource implements IResource<Pais> {
	@Autowired
	private PaisService paisService;

	public ResponseEntity<String> insert(@Valid @RequestBody Pais insertMODEL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> update(@Valid @RequestBody Pais updateMODEL, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResponseEntity<String> delete(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pais> findById(Integer id) {
		Pais pais = paisService.findById(id);
		return ResponseEntity.ok().body(pais);
	}

	@RequestMapping(value = "/paises", method = RequestMethod.GET)
	public ResponseEntity<List<Pais>> findLike(@Valid @RequestBody Pais pesquisaObjeto) {
		List<Pais> listaPaises = paisService.findLike(pesquisaObjeto);
		return ResponseEntity.ok().body(listaPaises);
	}

	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	public ResponseEntity<String> upload(@RequestParam MultipartFile edtInputFile) {
		String retorno = paisService.uploadFile(edtInputFile);
		return ResponseEntity.ok().body(retorno);

	}

}