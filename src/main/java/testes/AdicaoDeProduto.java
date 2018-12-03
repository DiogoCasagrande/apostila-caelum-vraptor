package testes;

import dao.ProdutoDao;
import model.Produto;

public class AdicaoDeProduto{
	public static void main(String[]args){
		Produto produto = new ProdutoDao().criaProduto();
		
		new ProdutoDao().salve(produto);
	}

}