package controller;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;

import model.dao.DAOGenerico;
import model.entity.Pessoa;
import util.PropriedadesProjeto;

@ManagedBean
public class CadastroPessoa {
	
	private Integer maioridade = Integer.parseInt(PropriedadesProjeto.getTexto("Brasil.properties", "pessoa.maioridade"));
	
	private Pessoa pessoa = new Pessoa();
	
	public void cadastrar() {
		DAOGenerico.getInstance().inserir(pessoa);
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
	
	public void test() {
		System.out.println(pessoa.getNome());
	}

}
