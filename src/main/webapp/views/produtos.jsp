<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Listagem de Produtos</title>
</head>
<body>
<h1>Produtos</h1>
<table border="1">
    <tr>
        <th>Nome</th>
        <th>Preço</th>
    </tr>
    <%
        List<Produto> produtos = (List<Produto>) request.getAttribute("produtos");
        for (Produto produto : produtos) {
    %>
    <tr>
        <td><%= produto.getNome() %></td>
        <td><%= produto.getPreco() %></td>
    </tr>
    <%
        }
    %>
</table>
<a href="form.jsp">Cadastrar novo produto</a>
</body>
</html>
