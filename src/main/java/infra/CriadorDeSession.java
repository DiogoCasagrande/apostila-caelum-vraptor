package infra;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import br.com.caelum.vraptor.ioc.Component;
import br.com.caelum.vraptor.ioc.ComponentFactory;

@Component
public class CriadorDeSession implements ComponentFactory<Session>{
	
	private SessionFactory factory;

	public CriadorDeSession(SessionFactory factory) {
		this.factory = factory;
	}
	
	public Session getInstance() {
		Session session = factory.openSession();
		return session;
	}
	
}
