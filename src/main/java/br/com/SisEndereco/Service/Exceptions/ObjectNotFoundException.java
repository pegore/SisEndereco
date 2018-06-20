package br.com.SisEndereco.Service.Exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * Construtor com os parametros:
	 * 
	 * @param mensagem
	 */
	public ObjectNotFoundException(String mensagem) {
		super(mensagem);
	}

	/**
	 * Construtor com os parametros:
	 * 
	 * @param mensagem
	 * @param causa
	 */
	public ObjectNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
