import java.util.ArrayList;

import br.com.caelum.vraptor.Resource;
import dao.ProdutoDao;

import java.util.*;
@Resource
public class Mundo {
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
		new ProdutoDao().listaTudo().forEach(action -> {System.out.println(action.getNome());});
		return result;
	}
}
