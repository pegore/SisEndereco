package br.com.SisEndereco.Domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Bairro implements BaseModel, Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idBairro")
	private Integer id;

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

	@ManyToOne
	@JoinColumn(name = "idMunicipio")
	private Municipio municipio;
}
