package br.com.fiap.check.entity;

import java.io.Serializable;
import java.util.Set;
import java.util.List;
import javax.persistence.OneToMany;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tb_carro")
@SequenceGenerator(name = "carro", sequenceName = "SQ_TB_CARRO", allocationSize = 1)
public class Carro implements Serializable {
	
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 8380490956827540935L;

	

	public Carro(String placa, String cor, String chassi) {
		super();
		this.placa = placa;
		this.cor = cor;
		this.chassi = chassi;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "carro")
	private Long id;

	@Column(name = "ds_placa", length = 7, nullable = false, unique = true)
	private String placa;
	
	@Column(name = "ds_cor", length = 30, nullable = false)
	private String cor;
	
	@Column(name = "ds_chassi", length = 17, nullable = false, unique = true)
	private String chassi;
	
	@OneToMany(mappedBy = "carro", fetch = FetchType.EAGER)
	private Set<Modelo> modelos;
	
	@OneToMany(mappedBy = "carro")
	private List<Acessorio> acessorios;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}
	
	
	public Set<Modelo> getModelos() {
		return modelos;
	}

	public void setModelos(Set<Modelo> modelos) {
		this.modelos = modelos;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}

	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}

	@Override
	public String toString() {
		
		return "\nPlaca: " + this.getPlaca() 
			+ "\nCor: " + this.getCor()
			+ "\nChassi: " + this.getChassi();
		}
}
