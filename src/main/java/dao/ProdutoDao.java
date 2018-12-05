package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.caelum.vraptor.ioc.Component;
import infra.CriadorDeSession;
import model.Produto;

@Component
public class ProdutoDao {

	private final Session session;

	public ProdutoDao(Session session) {
		this.session = session;
	}

	public void salve(Produto produto) {
		Transaction tx = session.beginTransaction();
		session.save(produto);
		tx.commit();
	}

	public Produto criaProduto() {
		Produto produto = new Produto();
		produto.setNome("Prateleira");
		produto.setDescricao("Uma prateleira para livros");
		produto.setPreco(35.90);
		return produto;
	}

	public void remocaoDeProduto() {
		Produto produto = (Produto) session.load(Produto.class, 1L);
		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
	}

	public List<Produto> listaTudo() {
		return this.session.createCriteria(Produto.class).list();
	}

	public Produto carrega(Long id) {
		return (Produto) this.session.load(Produto.class, id);
	}
	
	public void atualiza(Produto produto) {
		Transaction tx = session.beginTransaction();
		this.session.update(produto);
		tx.commit();
	}

}