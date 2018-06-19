package br.com.SisEndereco.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Municipio implements BaseModel, Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private int codigoMunicIBGE;
	private String nomeMunicipio;
	private boolean ativo;
	private Estado estado;
	private List<Bairro> bairros = new ArrayList<Bairro>();

	/**
	 * Construtor padrão da classe
	 */
	public Municipio() {
	}

	/**
	 * Construtor da Classe
	 * 
	 * @param id
	 * @param codigoMunicIBGE
	 * @param nomeMunicipio
	 * @param ativo
	 * @param estado
	 */
	public Municipio(int id, int codigoMunicIBGE, String nomeMunicipio, boolean ativo, Estado estado) {
		super();
		this.id = id;
		this.codigoMunicIBGE = codigoMunicIBGE;
		this.nomeMunicipio = nomeMunicipio;
		this.ativo = ativo;
		this.estado = estado;
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
	 * Captura o valor contido no parametro codigoMunicIBGE
	 */
	public int getCodigoMunicIBGE() {
		return codigoMunicIBGE;
	}

	/**
	 * Setar o valor para o parametro codigoMunicIBGE
	 */
	public void setCodigoMunicIBGE(int codigoMunicIBGE) {
		this.codigoMunicIBGE = codigoMunicIBGE;
	}

	/**
	 * Captura o valor contido no parametro nomeMunicipio
	 */
	public String getNomeMunicipio() {
		return nomeMunicipio;
	}

	/**
	 * Setar o valor para o parametro nomeMunicipio
	 */
	public void setNomeMunicipio(String nomeMunicipio) {
		this.nomeMunicipio = nomeMunicipio;
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
	 * Captura o valor contido no parametro estado
	 */
	public Estado getEstado() {
		return estado;
	}

	/**
	 * Setar o valor para o parametro estado
	 */
	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	/**
	 * Captura o valor contido no parametro bairros
	 */
	public List<Bairro> getBairros() {
		return bairros;
	}

	/**
	 * Setar o valor para o parametro bairros
	 */
	public void setBairros(List<Bairro> bairros) {
		this.bairros = bairros;
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
		Municipio other = (Municipio) obj;
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
				"\nIdentificador Municipio: " + getId() + //
				"\nCódigo IBGE.. .........: " + getCodigoMunicIBGE() + //
				"\nNome Completo..........: " + getNomeMunicipio() + //
				"\nEstado a que pertence..: " + getEstado() + //
				"\nAtivo..................: " + (isAtivo() ? "Sim" : "Não");
	}

}
