package br.com.projetoweb.servlets;

import br.com.projetoweb.dao.VeiculoDAO;
import br.com.projetoweb.dao.VeiculoDAOMySQL;
import br.com.projetoweb.model.Veiculo;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author roberto.lima
 */
@WebServlet("/inserirVeiculo")
public class InserirVeiculo extends HttpServlet {

    private final VeiculoDAO dao = new VeiculoDAOMySQL();

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        insert(request);
        response.sendRedirect("listarVeiculos");
    }

    private void insert(HttpServletRequest request) {
        Veiculo veiculo = new Veiculo();
        veiculo.setPlaca(String.valueOf(request.getAttribute("placa")));
        veiculo.setModelo(String.valueOf(request.getAttribute("modelo")));
        veiculo.setMarca(String.valueOf(request.getAttribute("marca")));
        veiculo.setLugares(Integer.valueOf(String.valueOf(request.getAttribute("lugares"))));
        veiculo.setValorAluguel(Double.valueOf(String.valueOf(request.getAttribute("valorAluguel"))));
        this.dao.insert(veiculo);
    }
}
