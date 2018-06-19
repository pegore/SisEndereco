/**
 * 
 */
package br.com.SisEndereco.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Lino Pegoretti
 *
 */

public class Estado implements BaseModel, Serializable {
	private static final long serialVersionUID = 1L;

	private int id; // Identificador único do Estado
	private int codigoIBGE; // Código do Estado pelo IBGE
	private String sigla; // Sigla do Estado
	private String nomeEstado; // Nome Completo do Estado
	private boolean ativo; // Identifica se o Estado cadastrado está ou não ativo
	private Pais pais; // Pais a que o estado atual pertence
	private List<Municipio> municipios = new ArrayList<Municipio>(); // lista de municipios do estado atual

	/**
	 * Construtor Padrão da Classe
	 */
	public Estado() {
	}

	/**
	 * construtor da Classe
	 * 
	 * @param id
	 * @param codigoIBGE
	 * @param sigla
	 * @param nomeEstado
	 * @param ativo
	 * @param pais
	 */
	public Estado(int id, int codigoIBGE, String sigla, String nomeEstado, boolean ativo, Pais pais) {
		super();
		this.id = id;
		this.codigoIBGE = codigoIBGE;
		this.sigla = sigla;
		this.nomeEstado = nomeEstado;
		this.ativo = ativo;
		this.pais = pais;
	}

	/**
	 * Captura o valor contido no parametro id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setar o valor para o parametro id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Captura o valor contido no parametro codigoIBGE
	 */
	public int getCodigoIBGE() {
		return codigoIBGE;
	}

	/**
	 * Setar o valor para o parametro codigoIBGE
	 */
	public void setCodigoIBGE(int codigoIBGE) {
		this.codigoIBGE = codigoIBGE;
	}

	/**
	 * Captura o valor contido no parametro sigla
	 */
	public String getSigla() {
		return sigla;
	}

	/**
	 * Setar o valor para o parametro sigla
	 */
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	/**
	 * Captura o valor contido no parametro nomeEstado
	 */
	public String getNomeEstado() {
		return nomeEstado;
	}

	/**
	 * Setar o valor para o parametro nomeEstado
	 */
	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	/**
	 * Captura o valor contido no parametro ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}

	/**
	 * Setar o valor para o parametro ativo
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	/**
	 * Captura o valor contido no parametro pais
	 */
	public Pais getPais() {
		return pais;
	}

	/**
	 * Setar o valor para o parametro pais
	 */
	public void setPais(Pais pais) {
		this.pais = pais;
	}

	/**
	 * Captura o valor contido no parametro municipios
	 */
	public List<Municipio> getMunicipios() {
		return municipios;
	}

	/**
	 * Setar o valor para o parametro municipios
	 */
	public void setMunicipios(List<Municipio> municipios) {
		this.municipios = municipios;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estado other = (Estado) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * ToString da classe
	 */
	@Override
	public String toString() {
		return "\nClasse ................: " + getClass().getSimpleName() + //
				"\nIdentificador Estado...: " + getId() + //
				"\nCódigo IBGE.. .........: " + getCodigoIBGE() + //
				"\nNome Completo..........: " + getNomeEstado() + //
				"\nSigla..................: " + getSigla() + //
				"\nPais que pertence......: " + getPais() + //
				"\nAtivo..................: " + (isAtivo() ? "Sim" : "Não");
	}
}
