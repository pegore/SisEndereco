package br.com.SisEndereco.Service;

import java.util.List;

/**
 * Interface para classes de serviço do projeto
 * 
 * @author Lino Pegoretti
 *
 * @param <MODEL>
 */
public interface IService<MODEL> {

	/**
	 * Inserção de um novo objeto no BD
	 * 
	 * @param objetoInsert
	 *            - um objeto a ser inserido no BD
	 * @return String - uma mensagem de retorno
	 */
	public MODEL insert(MODEL insertMODEL);

	/**
	 * Atualização de um objeto no BD
	 * 
	 * @param updateMODEL
	 *            - um objeto para ser atualizado no BD
	 * @return String - Uma mensagme de retorno
	 */
	public MODEL update(MODEL updateMODEL);

	/**
	 * Remoção de um objeto do BD
	 * 
	 * @param id
	 *            - Id de um objeto para remover do BD
	 * @return String - Uma mensagem de retorno
	 */
	public String delete(Integer id);

	/**
	 * Busca um único objeto por Id no BD
	 * 
	 * @param id
	 *            - Ide de um objeto a ser buscado no BD
	 * @return MODEL - um objeto retornado no banco
	 * 
	 */
	public MODEL findById(Integer id);

	/**
	 * Pesquisa uma lista de objetos no bd de acordo com o modelo passado por
	 * referencia
	 * 
	 * @param pesquisaMODEL
	 *            - um objeto para ser utilizado como exemplo para pesquisa
	 * @return List(MODEL) - uma lista com os objetos encontrados no BD
	 */
	public List<MODEL> findLike(MODEL pesquisaMODEL);
}
