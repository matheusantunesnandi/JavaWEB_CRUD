package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import model.dao.DAOGenerico;
import model.entity.Pessoa;
import util.PropriedadesProjeto;

@ManagedBean
public class CadastroPessoa {
	
	DAOGenerico daog = DAOGenerico.getInstance();
	
	private Integer maioridade = Integer.parseInt(PropriedadesProjeto.getTexto("Brasil.properties", "pessoa.maioridade"));
	
	private Pessoa pessoa = new Pessoa();
	
	public void salvar() {
		daog.inserir(pessoa);
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
	
	public List<Pessoa> getPessoas() {
		return daog.listar(Pessoa.class);
	}
}
