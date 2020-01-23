package model.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cruzeiro implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7672041021456676239L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private String nome;

	@Column
	private Date criacao = new Date();

	@Column
	private Date edicao;

	@Column
	private Date inicio;

	@Column
	private Date termino;

	@Column
	private String descricao;

	@Column
	private Embarcacao embarcacao;
	
//	@OneToMany
	private ArrayList<Pessoa> passageiros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getTermino() {
		return termino;
	}

	public void setTermino(Date termino) {
		this.termino = termino;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}

	public ArrayList<Pessoa> getPassageiros() {
		return passageiros;
	}

	public void setPassageiros(ArrayList<Pessoa> passageiros) {
		this.passageiros = passageiros;
	}
}
