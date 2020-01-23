package controller;

import javax.faces.bean.ManagedBean;

import model.dao.DAOGenerico;
import model.entity.Cruzeiro;

@ManagedBean
public class CadastroCruzeiro {

	private Cruzeiro cruzeiro = new Cruzeiro();

	public void salvar() {
		DAOGenerico.getInstance().inserir(cruzeiro);
	}

	public Cruzeiro getCruzeiro() {
		return cruzeiro;
	}

	public void setCruzeiro(Cruzeiro cruzeiro) {
		this.cruzeiro = cruzeiro;
	}
}
