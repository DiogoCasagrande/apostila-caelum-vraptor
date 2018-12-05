package testes;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import dao.ProdutoDao;
import infra.CriadorDeSession;
import infra.CriadorDeSessionFactory;

public class RemocaoDeProduto {
	public static void main(String[] args) {
		SessionFactory factory = new CriadorDeSessionFactory().getInstance();
		Session session = new CriadorDeSession(factory).getInstance();
		
		
		new ProdutoDao(session).remocaoDeProduto();
	}

}
