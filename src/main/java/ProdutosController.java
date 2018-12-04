import br.com.caelum.vraptor.Resource;
import dao.ProdutoDao;
import model.Produto;

import java.util.List;

@Resource
public class ProdutosController {

    private final ProdutoDao dao;

    public ProdutosController(ProdutoDao dao){
        this.dao = dao;
    }
    public List<Produto> lista(){
        System.out.println("lista");
        return dao.listaTudo();
    }
    
    public void adiciona(Produto produto) {
    	dao.salve(produto);
    }
    
    public void formulario() {
    	
    }
}
