package dao;

import model.Produto;
import java.sql.*;
import java.util.*;

public class ProdutoDAO {
    private Connection connection;

    public ProdutoDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para listar todos os produtos
    public List<Produto> listarProdutos() throws SQLException {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            Produto produto = new Produto(
                    resultSet.getInt("id"),
                    resultSet.getString("nome"),
                    resultSet.getDouble("preco")
            );
            produtos.add(produto);
        }

        return produtos;
    }

    // Método para salvar um produto
    public void salvarProduto(Produto produto) throws SQLException {
        String sql = "INSERT INTO produtos (nome, preco) VALUES (?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, produto.getNome());
        preparedStatement.setDouble(2, produto.getPreco());
        preparedStatement.executeUpdate();
    }

    public void close() {
    }
}
