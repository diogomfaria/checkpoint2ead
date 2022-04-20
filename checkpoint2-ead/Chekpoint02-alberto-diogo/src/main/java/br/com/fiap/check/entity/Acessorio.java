package br.com.fiap.check.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_acessorio")
@SequenceGenerator(name = "acessorio", sequenceName = "SQ_TB_ACESSORIO", allocationSize = 1)
public class Acessorio implements Serializable {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = -9199245293607983709L;

	public Acessorio(String descricao) {
		super();
		this.descricao = descricao;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "acessorio")
	private Long id;
	
	@Column(name = "ds_descricao")
	private String descricao;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "carro_id")
	private Carro carro;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	@Override
	public String toString() {
		
		return "\nDescrição: " + this.getDescricao();
		}
	
	
}
