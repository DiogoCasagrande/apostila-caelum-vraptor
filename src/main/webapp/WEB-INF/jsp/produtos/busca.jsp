<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<title>Insert title here</title>
</head>
<body>
	<h3>
		Resultados da busca pelo nome <b>"${nome }"</b>
	</h3>
	<%@ include file="lista.jsp"%>

<div id="menu">
		<ul>
			<li><a href="<c:url value="/produtos/novo/"/>">Novo Produto</a></li>
			<li><a href="<c:url value="/produtos/"/>">Lista Produtos</a></li>
			<li>
				<form action="<c:url value="/produtos/busca/"/>">
					<input id="busca" name="nome" />
				</form>
				<script type="text/javascript">
					$("#busca").puts("Busca produtos por nome");	
					$("#busca").autocomplete('/teste/produtos/busca.json',{
						dataType:"json",
						parse: function(produtos){
							return $.map(produtos, function(produto){
								return {
									data: produto,
									value: produto.nome,
									result: produto.nome
								}
							})
						},
						formatItem: function(produto){
							return produto.nome + "("+ produto.preco +")";
						}
					});
				</script>
			</li>
		</ul>
	</div>


</body>
</html>