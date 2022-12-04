package br.com.projetoweb.servlets;

import br.com.projetoweb.dao.VeiculoDAO;
import br.com.projetoweb.dao.VeiculoDAOMySQL;
import br.com.projetoweb.model.Veiculo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author roberto.lima
 */
@WebServlet(name = "listarVeiculos", urlPatterns = "/listarVeiculos")
public class ListarVeiculos extends HttpServlet {

    private VeiculoDAO dao = new VeiculoDAOMySQL();
    public List<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        listarVeiculos();
        request.setAttribute("veiculos", veiculos);
        RequestDispatcher rd
                = request.getRequestDispatcher("/ListaDeVeiculos.jsp");
        rd.forward(request, response);

    }

    private void listarVeiculos() {
        veiculos = dao.listAll();
    }
}
