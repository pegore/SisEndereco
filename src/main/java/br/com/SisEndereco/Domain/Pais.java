/**
 * 
 */
package br.com.SisEndereco.Domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Classe padrão para os paises do sistema de endereço
 * 
 * @author Lino Pegoretti
 *
 */

@Document
public class Pais implements BaseModel, Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPais")
	private Integer id; // Identificador Único do País
	private Integer codigoOnu; // Código do País na ONU
	private String codigoAlfa2; // Código Alfanumerico 2 digitos
	private String codigoAlfa3; // Código Alfanumerico 3 digitos
	private String nomePortugues; // Nome do País em lingua portuguesa
	private String nomeIngles; // Nome do País em lingua inglesa
	private String nomeFrances;// Nome do País em lingua francesa
	private String codigoDDI; // Código de discagem Direta Internacional
	private boolean ativo; // Identifica se o país cadastrado está ou não ativo
	//@OneToMany(mappedBy = "pais")
	private List<Estado> estados = new ArrayList<Estado>();

	/**
	 * Construtor padrão da classe
	 */
	public Pais() {
	}

	/**
	 * Construtor padrão da classe
	 * 
	 * @param id
	 * @param codigoOnu
	 * @param codigoAlfa2
	 * @param codigoAlfa3
	 * @param nomePortugues
	 * @param nomeIngles
	 * @param nomeFrances
	 * @param codigoDDI
	 * @param ativo
	 */
	public Pais(Integer id, Integer codigoOnu, String codigoAlfa2, String codigoAlfa3, String nomePortugues,
			String nomeIngles, String nomeFrances, String codigoDDI, boolean ativo) {
		super();
		this.id = id;
		this.codigoOnu = codigoOnu;
		this.codigoAlfa2 = codigoAlfa2;
		this.codigoAlfa3 = codigoAlfa3;
		this.nomePortugues = nomePortugues;
		this.nomeIngles = nomeIngles;
		this.nomeFrances = nomeFrances;
		this.codigoDDI = codigoDDI;
		this.ativo = ativo;
	}

	/**
	 * Captura o valor contido no parametro id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setar o valor para o parametro id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Captura o valor contido no parametro codigoOnu
	 */
	public Integer getCodigoOnu() {
		return codigoOnu;
	}

	/**
	 * Setar o valor para o parametro codigoOnu
	 */
	public void setCodigoOnu(Integer codigoOnu) {
		this.codigoOnu = codigoOnu;
	}

	/**
	 * Captura o valor contido no parametro codigoAlfa2
	 */
	public String getCodigoAlfa2() {
		return codigoAlfa2;
	}

	/**
	 * Setar o valor para o parametro codigoAlfa2
	 */
	public void setCodigoAlfa2(String codigoAlfa2) {
		this.codigoAlfa2 = codigoAlfa2;
	}

	/**
	 * Captura o valor contido no parametro codigoAlfa3
	 */
	public String getCodigoAlfa3() {
		return codigoAlfa3;
	}

	/**
	 * Setar o valor para o parametro codigoAlfa3
	 */
	public void setCodigoAlfa3(String codigoAlfa3) {
		this.codigoAlfa3 = codigoAlfa3;
	}

	/**
	 * Captura o valor contido no parametro nomePortugues
	 */
	public String getNomePortugues() {
		return nomePortugues;
	}

	/**
	 * Setar o valor para o parametro nomePortugues
	 */
	public void setNomePortugues(String nomePortugues) {
		this.nomePortugues = nomePortugues;
	}

	/**
	 * Captura o valor contido no parametro nomeIngles
	 */
	public String getNomeIngles() {
		return nomeIngles;
	}

	/**
	 * Setar o valor para o parametro nomeIngles
	 */
	public void setNomeIngles(String nomeIngles) {
		this.nomeIngles = nomeIngles;
	}

	/**
	 * Captura o valor contido no parametro nomeFrances
	 */
	public String getNomeFrances() {
		return nomeFrances;
	}

	/**
	 * Setar o valor para o parametro nomeFrances
	 */
	public void setNomeFrances(String nomeFrances) {
		this.nomeFrances = nomeFrances;
	}

	/**
	 * Captura o valor contido no parametro codigoDDI
	 */
	public String getCodigoDDI() {
		return codigoDDI;
	}

	/**
	 * Setar o valor para o parametro codigoDDI
	 */
	public void setCodigoDDI(String codigoDDI) {
		this.codigoDDI = codigoDDI;
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
	 * Captura o valor contido no parametro estados
	 */
	public List<Estado> getEstados() {
		return estados;
	}

	/**
	 * Setar o valor para o parametro estados
	 */
	public void setEstados(List<Estado> estados) {
		this.estados = estados;
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
		Pais other = (Pais) obj;
		if (id != other.id)
			return false;
		return true;
	}

	/*
	 * ToString da classe
	 */
	@Override
	public String toString() {
		return String.format(//
				"\nClasse ................: " + getClass().getSimpleName() + //
						"\nIdentificador País.....: " + getId() + //
						"\nCódigo da ONU .........: " + getCodigoOnu() + //
						"\nCodigo Alfa2...........: " + getCodigoAlfa2() + //
						"\nCodigo Alfa3...........: " + getCodigoAlfa3() + //
						"\nNome Portugues.........: " + getNomePortugues() + //
						"\nNome Ingles............: " + getNomeIngles() + //
						"\nNome Frances...........: " + getNomeFrances() + //
						"\nAtivo..................: " + (isAtivo() ? "Sim" : "Não"));
	}

}
