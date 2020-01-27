package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.DAOGenerico;
import model.entity.Pessoa;
import util.PropriedadesProjeto;

@ManagedBean
@SessionScoped
public class CadastroPessoa {

	private Integer maioridade = Integer
			.parseInt(PropriedadesProjeto.getTexto("Brasil.properties", "pessoa.maioridade"));

	private Pessoa pessoa = new Pessoa();

	public List<Pessoa> getPessoas() {
		return DAOGenerico.getInstance().listar(Pessoa.class);
	}

	public void salvar() {
		if (pessoa.getId() == null) {
			DAOGenerico.getInstance().inserir(pessoa);
			pessoa = new Pessoa();

		} else {
			DAOGenerico.getInstance().atualizar(pessoa);
			pessoa = new Pessoa();
		}
	}

	public void editar(Pessoa p) {
		this.pessoa = p;
	}

	public void remover(Pessoa p) {
		DAOGenerico.getInstance().remover(p);

		if (pessoa.getId() == p.getId())
			pessoa = new Pessoa();
	}

	public Date getDataMaioridade() {
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -maioridade);

		return c.getTime();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
}
