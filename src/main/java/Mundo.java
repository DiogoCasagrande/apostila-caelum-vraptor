import java.util.ArrayList;
import java.util.List;

import br.com.caelum.vraptor.Resource;
import dao.ProdutoDao;
@Resource
public class Mundo {
	
	private final ProdutoDao dao;
	
	public Mundo(ProdutoDao dao) {
		this.dao = dao;
	}
	
	public String boasVindas() {
		return "Olá mundo - return";
	}
	
	public List<String> paises(){
		List<String> result = new ArrayList<String>();

		System.out.println("Hello paises----------------");
		result.add("Brasil");
		result.add("Portugal");
		result.add("Japão");
		result.add("Canadá");
		result.add("Paraguai");
		dao.listaTudo().forEach(action -> {System.out.println(action.getNome());});
		return result;
	}
}
