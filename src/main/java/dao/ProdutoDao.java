package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import infra.CriadorDeSession;
import model.Produto;

public class ProdutoDao {

	private final Session session;
	
	public ProdutoDao() {
		this.session = CriadorDeSession.getSession();
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
		Produto produto = (Produto)session.load(Produto.class, 1L);
		Transaction tx = session.beginTransaction();
		session.delete(produto);
		tx.commit();
	}

}
