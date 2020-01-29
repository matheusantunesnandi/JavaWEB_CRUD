package controller;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import model.dao.DAOGenerico;
import model.entity.Pessoa;
import util.PropriedadesProjeto;

@ManagedBean
@SessionScoped
public class CadastroPessoa {

	private Integer maioridade = Integer
			.parseInt(PropriedadesProjeto.getTexto("Brasil.properties", "pessoa.maioridade"));

	private Pessoa pessoa = new Pessoa();

	private boolean isEditando = false;

	public List<Pessoa> getPessoas() {
		return DAOGenerico.getInstance().listar(Pessoa.class);
	}

	public void salvar() {
		if (!isEntradasValidas())
			return;

		if (pessoa.getId() == null) {
			DAOGenerico.getInstance().inserir(pessoa);
			pessoa = new Pessoa();

		} else {
			DAOGenerico.getInstance().atualizar(pessoa);
			cancelar();
		}
	}

	public void editar(Pessoa p) {
		this.pessoa = p;
		isEditando = true;
	}

	public void remover(Pessoa p) {
		DAOGenerico.getInstance().remover(p);

		if (pessoa.getId() == p.getId())
			cancelar();
	}

	public void cancelar() {
		pessoa = new Pessoa();
		isEditando = false;
	}

	public boolean isEntradasValidas() {
//		Quando houverem mais de uma, para que todas as mensagens apareçam sem o usuário ter que ir preenchendo elemento por elemento, nestes casos é interessante utilizar uma variável boolean no lugar de vários return;
		boolean retorno = true;

		if (!pessoa.getNascimento().before(getDataMaioridade())
				&& !pessoa.getNascimento().equals(getDataMaioridade())) {

//			TODO: Mensagem da Maioridade não está aparecendo.
			FacesContext.getCurrentInstance().addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Maioridade:", "Obrigatório ter maioridade."));
			retorno = false;
		}

		return retorno;
	}

	public Date getDataMaioridade() {
		Calendar c = GregorianCalendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.YEAR, -maioridade);
		Calendar dc = new GregorianCalendar(c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH));
		return dc.getTime();
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public boolean isEditando() {
		return isEditando;
	}

	public void setEditando(boolean isEditando) {
		this.isEditando = isEditando;
	}
}
