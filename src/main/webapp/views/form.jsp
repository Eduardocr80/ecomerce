<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cadastro de Produto</title>
</head>
<body>
<h1>Cadastrar Produto</h1>
<form action="produtos" method="post">
    <label for="nome">Nome:</label>
    <input type="text" id="nome" name="nome" required><br><br>
    <label for="preco">Preço:</label>
    <input type="number" id="preco" name="preco" required><br><br>
    <button type="submit">Cadastrar</button>
</form>
</body>
</html>
