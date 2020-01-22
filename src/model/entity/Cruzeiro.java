package model.entity;

import java.util.ArrayList;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cruzeiro {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column
	private Calendar criacao;

	@Column
	private Calendar edicao;

	@Column
	private Calendar inicio;

	@Column
	private Calendar termino;

	@Column
	private String descricao;

	@Column
	private Embarcacao embarcacao;

//	@OneToMany(mappedBy = "cruzeiro")
	@OneToMany
	private ArrayList<Pessoa> passageiros;
}
