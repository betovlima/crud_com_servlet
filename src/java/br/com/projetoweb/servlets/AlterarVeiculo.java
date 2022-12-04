package br.com.projetoweb.servlets;

import br.com.projetoweb.dao.VeiculoDAO;
import br.com.projetoweb.dao.VeiculoDAOMySQL;
import br.com.projetoweb.model.Veiculo;
import br.com.projetoweb.utils.Utils;
import java.io.IOException;
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
@WebServlet(name = "alterarVeiculo", urlPatterns = "/alterarVeiculo")
public class AlterarVeiculo extends HttpServlet {

    private VeiculoDAO dao = new VeiculoDAOMySQL();
    public Veiculo veiculo = new Veiculo();
    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private Integer lugares;
    private Double valorAluguel;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String acao = request.getParameter("acao");
        String veiculoID = request.getParameter("veiculoID");
        this.id = Long.valueOf(veiculoID);
        if (acao.equals("carregar")) {
            getVeiculo(this.id);
            request.setAttribute("veiculoID", this.veiculo.getId());
            request.setAttribute("placa", this.veiculo.getPlaca());
            request.setAttribute("modelo", this.veiculo.getModelo());
            request.setAttribute("marca", this.veiculo.getMarca());
            request.setAttribute("lugares", this.veiculo.getLugares());
            request.setAttribute("valorAluguelFormatado", Utils.getCurrencyValue(this.veiculo.getValorAluguel()));
            RequestDispatcher rd
                    = request.getRequestDispatcher("/AlterarVeiculos.jsp");
            rd.forward(request, response);

        } else if (acao.equals("alterar")) {
            
            this.placa = request.getParameter("placa");
            this.modelo = request.getParameter("modelo");
            this.marca = request.getParameter("marca");
            this.lugares = Integer.valueOf(request.getParameter("lugares"));
            this.valorAluguel = Double.valueOf(request.getParameter("valorAluguel"));
            updateRecord();
            response.sendRedirect("listarVeiculos");

        }

    }

    private void updateRecord() {
        veiculo.setId(id);
        veiculo.setLugares(lugares);
        veiculo.setMarca(marca);
        veiculo.setModelo(modelo);
        veiculo.setPlaca(placa);
        veiculo.setValorAluguel(valorAluguel);
        this.dao.updateRecord(veiculo);
    }

    private void getVeiculo(Long id) {
        this.veiculo = this.dao.getVeiculoById(id);
    }

}
