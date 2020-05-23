package controller;

import model.Produto;
import service.ProdutoService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListarProduto implements command.Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        /**
         * Retorna a lista de produtos pora a home
         */
        ProdutoService produtoService = new ProdutoService();

        ArrayList<Produto> lista =  produtoService.listarProdutos();

        request.setAttribute("produto", lista); //importante enviar o atributo na request pro font conseguir pegar
        RequestDispatcher view = request.getRequestDispatcher("home.jsp");
        view.forward(request, response);
    }

}