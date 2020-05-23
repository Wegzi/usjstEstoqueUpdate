package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Produto;
import service.ProdutoService;

public class CadastrarProduto implements command.Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    /**
     * Aqui é tudo igual ao atualizar produto exeto uma linha
     */
        String nomeProduto = request.getParameter("nome");
        String descProduto = request.getParameter("descricao");
        int codigoProduto = Integer.parseInt(request.getParameter("codigo"));
        double valorProduto = Double.parseDouble(request.getParameter("valor"));
        int estoqueProduto = Integer.parseInt(request.getParameter("estoque"));

        Produto produto = new Produto();
        produto.setCodigo(codigoProduto);
        produto.setNome(nomeProduto);
        produto.setDescricao(descProduto);
        produto.setValor(valorProduto);
        produto.setEstoque(estoqueProduto);

        ProdutoService produtoService = new ProdutoService();


        /**
         * Essa linha
         * Importante mandar o id do produto a ser alterado
         * o modo mais fácil é usar um input hidden na view com o valor do id
         */
        produtoService.alterar(produto);

        request.setAttribute("mensagem", "O produto foi cadastrado com sucesso!");

        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }

}