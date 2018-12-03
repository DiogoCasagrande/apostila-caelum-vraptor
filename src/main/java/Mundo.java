import java.util.ArrayList;

import br.com.caelum.vraptor.Resource;

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
		return result;
	}
}
