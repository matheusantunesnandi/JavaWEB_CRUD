package controller;

import javax.faces.bean.ManagedBean;

import model.dao.DAOGenerico;
import model.entity.Embarcacao;

@ManagedBean
public class CadastroEmbarcacao {

	private Embarcacao embarcacao = new Embarcacao();

	public void salvar() {
		DAOGenerico.getInstance().inserir(embarcacao);
	}
	
	public void getEmbarcacoes() {
		
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}
}
