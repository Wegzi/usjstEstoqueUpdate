package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Command;


/**w
 * Professor a vida é muito curta pra mim fazer esse servidor funcionar
 * Eu desenvolvi no escuro, era mais fácil eu usar o VIM doque fazer o eclipse funcionar
 * Eu deixei a view do jeito que tava no primeiro trabalho porque não vou conseguir testar
 * Eu vou comentar os blocos que achar importante e oque cada um faz
 *
 */

@WebServlet("/controller.do")
public class ServletController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doExecute(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doExecute(request, response);
    }

    protected void doExecute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {

            String comando = request.getParameter("command"); //A servlet espera uma string com o nome de uma classe
            /**
             * Cada request pro servidor pasaria por essa servelet
             * Ela é ou pode ser considerada um middleware
             * Recebe o comando/classe a ser executada
             *
             * Na linha abaixo é criada uma nova instancia da classe que é concatenado com a string command
             * ex: command.AtualizarProduto
             */
            Command command = (Command) Class.forName("command." + comando).newInstance();
//           Uma vez instanciada a classe executa a função execute
//           ex: command.AtualizarProduto.execute(params...)
            command.execute(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}