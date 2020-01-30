package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.DAOGenerico;
import model.entity.Embarcacao;

@ManagedBean
@SessionScoped
public class CadastroEmbarcacao {

	private Embarcacao embarcacao = new Embarcacao();
	
	private List<Embarcacao> embarcacoes;

	private boolean isEditando = false;

	public CadastroEmbarcacao() {
		embarcacoes = carregarEmbarcacoes();
	}
	
	public void salvar() {
		if (embarcacao.getId() == null) {
			DAOGenerico.getInstance().inserir(embarcacao);
			embarcacoes.add(embarcacao);
			embarcacao = new Embarcacao();

		} else {
			DAOGenerico.getInstance().atualizar(embarcacao);
			cancelar();
		}
	}

	public void editar(Embarcacao e) {
		this.embarcacao = e;
		isEditando = true;
	}

	public void remover(Embarcacao e) {
		DAOGenerico.getInstance().remover(e);
		embarcacoes.remove(e);

		if (embarcacao.getId() == e.getId())
			cancelar();
	}

	public void cancelar() {
		embarcacao = new Embarcacao();
		isEditando = false;
	}

	public List<Embarcacao> carregarEmbarcacoes() {
		return DAOGenerico.getInstance().listar(Embarcacao.class);
	}

	public Embarcacao getEmbarcacao() {
		return embarcacao;
	}

	public void setEmbarcacao(Embarcacao embarcacao) {
		this.embarcacao = embarcacao;
	}

	public boolean isEditando() {
		return isEditando;
	}

	public void setEditando(boolean isEditando) {
		this.isEditando = isEditando;
	}

	public List<Embarcacao> getEmbarcacoes() {
		return embarcacoes;
	}

	public void setEmbarcacoes(List<Embarcacao> embarcacoes) {
		this.embarcacoes = embarcacoes;
	}
}
