package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import model.dao.DAOGenerico;
import model.entity.Cruzeiro;

@ManagedBean
@SessionScoped
public class CadastroCruzeiro {

	private Cruzeiro cruzeiro = new Cruzeiro();

	private List<Cruzeiro> cruzeiros;

	private boolean isEditando = false;

	public CadastroCruzeiro() {
		cruzeiros = carregarCruzeiros();
	}

	public void salvar() {
//		if (!isEntradasValidas())
//			return;

		if (cruzeiro.getId() == null) {
			DAOGenerico.getInstance().inserir(cruzeiro);
			cruzeiros.add(cruzeiro);
			cruzeiro = new Cruzeiro();

		} else {
			DAOGenerico.getInstance().atualizar(cruzeiro);
			cancelar();
		}
	}

	public void editar(Cruzeiro p) {
		this.cruzeiro = p;
		isEditando = true;
	}

	public void remover(Cruzeiro p) {
		DAOGenerico.getInstance().remover(p);
		cruzeiros.remove(p);

		if (cruzeiro.getId() == p.getId())
			cancelar();
	}

	public void cancelar() {
		cruzeiro = new Cruzeiro();
		setEditando(false);
	}

//	public boolean isEntradasValidas() {
////		Quando houverem mais de uma, para que todas as mensagens apareçam sem o usuário ter que ir preenchendo elemento por elemento, nestes casos é interessante utilizar uma variável boolean no lugar de vários return;
//		boolean retorno = true;
//
//		if (true) {
//
////			TODO: Mensagem da Maioridade não está aparecendo.
//			FacesContext.getCurrentInstance().addMessage(null,
//					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maioridade:", "Obrigatório ter maioridade."));
//			retorno = false;
//		}
//
//		return retorno;
//	}

	public List<Cruzeiro> carregarCruzeiros() {
		return DAOGenerico.getInstance().listar(Cruzeiro.class);
	}

	public Cruzeiro getCruzeiro() {
		return cruzeiro;
	}

	public void setCruzeiro(Cruzeiro cruzeiro) {
		this.cruzeiro = cruzeiro;
	}

	public List<Cruzeiro> getCruzeiros() {
		return cruzeiros;
	}

	public void setCruzeiros(List<Cruzeiro> cruzeiros) {
		this.cruzeiros = cruzeiros;
	}

	public boolean isEditando() {
		return isEditando;
	}

	public void setEditando(boolean isEditando) {
		this.isEditando = isEditando;
	}
}
