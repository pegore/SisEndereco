package br.com.SisEndereco.Resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
public class PaisResource {
	@Autowired
	private PaisService paisService;
	// /**
	// * Recurso REST para inserção de um novo País no BD
	// * <p>
	// * URI para acesso:/paises
	// * <p>
	// * Arquivo JSON para modelo de categoria de produto:
	// * {@link br.com.SistemaLanchonete.ExemplosJSON.ProdutoCategoria.json}
	// *
	// * @param produtoCategoria
	// * - Um objeto do tipo ProdutoCategoriaBean para ser inserido no BD
	// *
	// * @return Response - Uma resposta do servidor principal<br>
	// * 200 quando inserido com sucesso<br>
	// * 500 quando houver erro interno
	// */
	// @POST
	// @Path("/produtoCategoria")
	// @Consumes({ MediaType.APPLICATION_JSON })
	// public Response insert(ProdutoCategoriaBean produtoCategoria) {
	// try {
	// new ProdutoCategoriaService().save(produtoCategoria);
	// return Response.status(200).entity("Categoria de Produto Inserida com
	// Sucesso").build();
	// } catch (Exception e) {
	// e.printStackTrace();
	// throw new WebApplicationException(500);
	// }
	// }
	//
	// /**
	// * Recurso REST para atualização de uma categoria de produto no BD *
	// * <p>
	// * URI para acesso:
	// *
	// http://localhost:8080/SistemaLanchonete/services/produtoCategoria/cdProdutoCategoria
	// * <p>
	// *
	// * @param cdProdutoCategoria
	// * - Um id de um ProdutoCategoriaBean para ser atualizado no BD
	// *
	// * @return Response - Uma resposta do servidor principal<br>
	// * 200 quando atualizado com sucesso<br>
	// * 500 quando houver erro interno
	// */
	// @PUT
	// @Path("/{cdProdutoCategoria}")
	// @Consumes(MediaType.APPLICATION_JSON)
	// public Response update(@PathParam("cdProdutoCategoria") int
	// cdProdutoCategoria) {
	// try {
	// ProdutoCategoriaBean produtoCategoria = new ProdutoCategoriaBean();
	// produtoCategoria.setCdProdutoCategoria(cdProdutoCategoria);
	// new ProdutoCategoriaService().save(produtoCategoria);
	// return Response.status(200).entity("Categoria de Produto alterada com
	// sucesso").build();
	// } catch (Exception e) {
	// throw new WebApplicationException(500);
	// }
	// }
	//
	// /**
	// * Recurso REST para remoção de uma categoria de produto no BD
	// * <p>
	// * URI para acesso:
	// *
	// http://localhost:8080/SistemaLanchonete/services/produtoCategoria/cdProdutoCategoria
	// * <p>
	// *
	// * @param cdProdutoCategoria
	// * - Um id de um ProdutoCategoriaBean para ser removido do BD
	// *
	// * @return Response - Uma resposta do servidor principal<br>
	// * 200 quando removido com sucesso<br>
	// * 500 quando houver erro interno
	// */
	// @DELETE
	// @Consumes(MediaType.APPLICATION_JSON)
	// @Path("/{cdProdutoCategoria}")
	// public Response delete(@PathParam("cdProdutoCategoria") int
	// cdProdutoCategoria) {
	// try {
	// ProdutoCategoriaBean produtoCategoria = new ProdutoCategoriaBean();
	// produtoCategoria.setCdProdutoCategoria(cdProdutoCategoria);
	// new ProdutoCategoriaService().remove(produtoCategoria);
	// return Response.status(200).entity("ProdutoCategoria excluída com
	// sucesso").build();
	// } catch (Exception e) {
	// throw new WebApplicationException(500);
	// }
	// }
	//

	/**
	 * Recurso REST para busca de um único País no BD
	 * <p>
	 * URI para acesso: pais/idPais
	 * <p>
	 * 
	 * @param cdProdutoCategoria
	 *            - Um id de um ProdutoCategoriaBean para ser buscado no BD
	 * 
	 * @return ProdutoCategoriaBean - Uma categoria de produto localizado no banco
	 *         de dados<br>
	 *         500 quando houver erro interno
	 */
	@RequestMapping(value = "/{idPais}", method = RequestMethod.GET)
	public ResponseEntity<Pais> findById(@PathVariable Integer idPais) {
		Pais pais = paisService.findById(idPais);
		return ResponseEntity.ok().body(pais);
	}

	/**
	 * Recurso REST para fazer uma busca de várias categorias de produto no BD de
	 * acordo com o valor passado por parametro na URL
	 * <p>
	 * URI para acesso: /paises/nomePortugues *
	 * <p>
	 * 
	 */

	@RequestMapping(value = "/paises", method = RequestMethod.GET)
	public ResponseEntity<List<Pais>> findPais(@Valid @RequestBody Pais paisPesquisa) {
		List<Pais> listaPaises = paisService.findPais(paisPesquisa);
		return ResponseEntity.ok().body(listaPaises);
	}
}