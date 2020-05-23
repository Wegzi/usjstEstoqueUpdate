package controller;

import model.Produto;
import service.ProdutoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class DeletarProduto implements command.Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /**
         * Deletar procutos
         * Receve um inteiro
         */
        int codigoProduto = Integer.parseInt(request.getParameter("codigo"));

        ProdutoService produtoService = new ProdutoService();


        /**
         * Originalmente excluir precisava de objeto Produto
         * Eu modifiquei para receber só de um inteiro, achei mais simples
         */
        produtoService.excluir(codigoProduto);

        request.setAttribute("mensagem", "O produto foi excluido com sucesso!");

//      Retorna o usuário para a home
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }


}
