import java.util.List;

import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import dao.ProdutoDao;
import model.Produto;

@Resource
public class ProdutosController {

    private final ProdutoDao dao;
    private final Result result;
    
    public ProdutosController(ProdutoDao dao, Result result){
        this.dao = dao;
        this.result = result;
    }
    public List<Produto> lista(){
        System.out.println("lista");
        return dao.listaTudo();
    }
    
    public void adiciona(Produto produto) {
    	dao.salve(produto);
    	result.redirectTo(this).lista();
    }
    
    public Produto edita(Long id) {
    	System.out.println("edita controller----");
    	return dao.carrega(id);
    }
    
    public void altera(Produto produto) {
    	dao.atualiza(produto);
    	result.redirectTo(this).lista();
    }
    
    public void formulario() {
    	
    }
}
