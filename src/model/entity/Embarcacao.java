package model.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Embarcacao {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Calendar criacao;

	@Column
	private Calendar edicao;

	@Column
	private String nome;

	@Column
	private String tipo;

	@Column
	private Integer lotacaoMaxima;
}
