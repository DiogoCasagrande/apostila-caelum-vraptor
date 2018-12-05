package testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProdutoDao;
import infra.CriadorDeSession;
import infra.CriadorDeSessionFactory;
import model.Produto;

public class AdicaoDeProduto{
	public static void main(String[]args){
		
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		
		Produto produto = new ProdutoDao(session).criaProduto();
		
		new ProdutoDao(session).salve(produto);
	}
}