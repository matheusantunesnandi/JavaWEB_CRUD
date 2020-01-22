package model.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4834392346122715167L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column
	private String nome;

	@Column
	private Date nascimento;

	@Column
	private String sexo;

	@Column
	private String observacao;

	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(id + " ");
		sb.append(nome + " ");
		sb.append(nascimento.toString() + " ");
		sb.append(sexo);

		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}
