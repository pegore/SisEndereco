package br.com.SisEndereco.Resource.Exceptions;

import java.io.Serializable;

public class StandardError implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long timestamp;
	private Integer status;
	private String error;
	private String message;
	private String path;
	
	/**
	 * @param timestamp
	 * @param status
	 * @param error
	 * @param message
	 * @param path
	 */
	public StandardError(Long timestamp, Integer status, String error, String message, String path) {
		super();
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
		this.message = message;
		this.path = path;
	}
	/**
	 * Captura o valor contido no parametro timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}
	/**
	 * Setar o valor para o parametro timestamp
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	/**
	 * Captura o valor contido no parametro status
	 */
	public Integer getStatus() {
		return status;
	}
	/**
	 * Setar o valor para o parametro status
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**
	 * Captura o valor contido no parametro error
	 */
	public String getError() {
		return error;
	}
	/**
	 * Setar o valor para o parametro error
	 */
	public void setError(String error) {
		this.error = error;
	}
	/**
	 * Captura o valor contido no parametro message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * Setar o valor para o parametro message
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Captura o valor contido no parametro path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * Setar o valor para o parametro path
	 */
	public void setPath(String path) {
		this.path = path;
	}
}
