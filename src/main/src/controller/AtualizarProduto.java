package controller;

import model.Produto;
import service.ProdutoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AtualizarProduto implements command.Command {


    /**
     * Acho que nada novo aqui, apenas a estrutura diferente implementando a interface como todas as outras
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Recebendo os parâmetros:
        String nomeProduto = request.getParameter("nome");
        String descProduto = request.getParameter("descricao");
        int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
        double valorProduto = Double.parseDouble(request.getParameter("valor"));
        int estoqueProduto = Integer.parseInt(request.getParameter("estoque"));

        // Instanciando e popular um JavaBean de Produto:
        Produto produto = new Produto();
        produto.setCodigo(codigoProduto);
        produto.setNome(nomeProduto);
        produto.setDescricao(descProduto);
        produto.setValor(valorProduto);
        produto.setEstoque(estoqueProduto);

        // Intanciando uma Service de Produto:
        ProdutoService produtoService = new ProdutoService();

        // Solicitando à service que registre o produto no banco:
        produtoService.alterar(produto);

        // Antes de despachar o usuário, adicionar um atributo à requisição:
        request.setAttribute("mensagem", "O produto foi alterado com sucesso!");

        // Despachar o usuário à parte de visão (apresentação - view):
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }
}
