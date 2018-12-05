<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="../javascript/jquery-1.3.2.min.js"></script>
<script type="text/javascript" src=".../jquery.validate.min.js"></script>
<script type="text/javascript" src="<c:url value="../jquery.puts.js"/>"></script>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Descrição</th>
				<th>Preço</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${produtoList}" var="produto">
				<tr>
					<td>${produto.id }</td>
					<td>${produto.nome}</td>
					<td>${produto.descricao}</td>
					<td>${produto.preco}</td>
					<td>
					<a href="<c:url value="/produtos/${produto.id}/"/>">Editar</a></td>
					<td>
						<form action="<c:url value="/produtos/${produto.id}/"/>" method="POST">
							<button class="link" name="_method" value="DELETE">Remover</button>
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<ul>
		<li><a href="<c:url value="/produtos/novo/"/>" >Novo Produto</a></li>
		<li>
			<form action="<c:url value="/produto/busca/"/>">
				<input name="nome"/>
			</form>
		</li>
	</ul>
	
	
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