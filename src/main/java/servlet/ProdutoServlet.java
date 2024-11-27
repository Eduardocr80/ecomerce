package servlet;

import dao.ProdutoDAO;
import model.Produto;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ProdutoServlet extends HttpServlet {
    private ProdutoDAO produtoDAO;

    public void init() throws ServletException {
        try {
            // Aqui você deve inicializar sua conexão com o banco de dados
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecommerce", "root", "senha");
            produtoDAO = new ProdutoDAO(connection);
        } catch (SQLException e) {
            throw new ServletException("Erro ao conectar no banco de dados", e);
        }
    }

    // Processa a requisição de listagem de produtos
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Produto> produtos = produtoDAO.listarProdutos();
            request.setAttribute("produtos", produtos);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/views/produtos.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            throw new ServletException("Erro ao listar produtos", e);
        }
    }

    // Processa a requisição de cadastro de produto
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nome = request.getParameter("nome");
        double preco = Double.parseDouble(request.getParameter("preco"));
        Produto produto = new Produto(0, nome, preco);

        try {
            produtoDAO.salvarProduto(produto);
            response.sendRedirect("produtos");
        } catch (SQLException e) {
            throw new ServletException("Erro ao salvar produto", e);
        }
    }

    public void destroy() {
        try {
            // Código que interage com o banco de dados e pode lançar SQLException
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomerce", "root", "root");
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM produtos");
            // Processar o resultado...
        } catch (SQLException e) {
            e.printStackTrace(); // Tratar o erro adequadamente
        }

    }
}
