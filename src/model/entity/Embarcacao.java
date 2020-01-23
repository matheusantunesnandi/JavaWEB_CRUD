package model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Embarcacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5698052552950058061L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Date criacao = new Date();

	@Column
	private Date edicao;

	@Column
	private String nome;

	@Column
	private String tipo;

	@Column
	private Integer lotacaoMaxima;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCriacao() {
		return criacao;
	}

	public void setCriacao(Date criacao) {
		this.criacao = criacao;
	}

	public Date getEdicao() {
		return edicao;
	}

	public void setEdicao(Date edicao) {
		this.edicao = edicao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getLotacaoMaxima() {
		return lotacaoMaxima;
	}

	public void setLotacaoMaxima(Integer lotacaoMaxima) {
		this.lotacaoMaxima = lotacaoMaxima;
	}
}