package br.com.SisEndereco.Resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Interface para classes REST
 * 
 * @author Lino Pegoretti
 *
 * @param <MODEL>
 */
public interface IResource<MODEL> {

	/**
	 * Recurso REST para inserção de um objeto no BD
	 * 
	 * @param insertObjeto
	 *            - Um objeto a ser inserido no BD
	 * @return - - ResponseEntity(String) - Uma mensagem de retorno
	 */
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insert(@Valid @RequestBody MODEL insertMODEL);

	/**
	 * Recurso REST para atualização de um objeto no BD
	 * 
	 * @param updateMODEL
	 *            - um objeto passado por parametro
	 * @param id
	 *            - um id pela URI para atualizar o objeto no BD
	 * @return - ResponseEntity(String) - Uma mensagem de retorno
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<String> update(@Valid @RequestBody MODEL updateMODEL, @PathVariable Integer id);

	/**
	 * Recurso REST para remoção de um objeto no BD
	 * 
	 * @param id
	 *            - um id pela URI para remover o objeto no BD
	 * @return
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<String> delete(@PathVariable Integer id);

	/**
	 * Recurso REST para busca de um único objeto no BD
	 * <p>
	 * URI para acesso: /MODEL/id
	 * <p>
	 * 
	 * @param id
	 *            - Id de um Objeto para ser buscado no BD
	 * 
	 * @return ResponseEntity(MODEL) - Um objeto localizado no banco de dados
	 */
	public ResponseEntity<MODEL> findById(@PathVariable Integer id);

	/**
	 * Recurso REST para fazer uma lista de objetos no BD de acordo com o valor
	 * passado
	 * <p>
	 * URI para acesso: /MODEL - usar o plural do modelo
	 * <p>
	 * 
	 * @param pesquisaMODEL
	 *            - um objeto de modelo para ser pesquisado no BD
	 * @return ResponseEntity - List(MODEL) - Uma lista do objeto enviado para
	 *         pesquisa
	 */
	public ResponseEntity<List<MODEL>> findLike(@Valid @RequestBody MODEL pesquisaMODEL);

	public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file);
	
	
}

