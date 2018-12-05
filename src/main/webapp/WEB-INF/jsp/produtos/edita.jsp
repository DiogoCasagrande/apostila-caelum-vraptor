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
</head>
<body>
	<form id="produtosForm"
		action="<c:url value="/produtos/${produto.id}/"/>" method="POST">
		<fieldset>
			<legend>Editar Produto</legend>
			<input type="hidden" name="produto.id" value="${produto.id}" /> <label
				for="nome">Nome:</label> <input id="nome" type="text"
				name="produto.nome" value="${produto.nome }" /> <label
				for="descricao">Descrição:</label>
			<textarea id="descricao" name="produto.descricao">${produto.descricao }</textarea>

			<label for="preco">Preco:</label> <input id="preco" type="text"
				name="produto.preco" value="${produto.preco}" />

			<button type="submit" name="_method" value="PUT">Enviar</button>
		</fieldset>
	</form>
	<ul>
		<c:forEach items="${errors }" var="error">
			<li>${error.category }-${error.message }</li>
		</c:forEach>
	</ul>

	<script type="text/javascript">
		$('#produtosForm').validate({
			rules : {
				"produto.nome" : {
					required : true,
					minlength : 3
				},
				"produto.descricao" : {
					required : true,
					maxlength : 40
				},
				"produto.preco" : {
					min : 0.0
				}
			}
		});
	</script>
</body>
</html>