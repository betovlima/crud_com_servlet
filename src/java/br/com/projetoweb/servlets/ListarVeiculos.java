/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetoweb.servlets;

import br.com.projetoweb.config.DatabaseConnection;
import br.com.projetoweb.model.Veiculo;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author roberto.lima
 */
@WebServlet("/listarVeiculos")
public class ListarVeiculos extends HttpServlet implements Servlet {

    public List<Veiculo> veiculos = new ArrayList<Veiculo>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        try ( Connection con = DatabaseConnection.initializeDatabase();  Statement st = con.createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM veiculo");) {
            veiculos.clear();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("veiculoID"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setLugares(rs.getInt("lugares"));
                Double valorAluguel = rs.getDouble("valorAluguel");
                veiculo.setValorAluguel(rs.getDouble("valorAluguel"));
                String valorAluguelFormatado = NumberFormat.getCurrencyInstance().format(valorAluguel);
                veiculo.setValorAluguelFormatado(valorAluguelFormatado);
                veiculos.add(veiculo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setAttribute("veiculos", veiculos);
        RequestDispatcher rd
                = request.getRequestDispatcher("ListaDeVeiculos.jsp");
        rd.forward(request, response);
        out.println("</body>");
        out.println("</html>");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        request.setAttribute("veiculos", veiculos);
        RequestDispatcher rd
                = request.getRequestDispatcher("ListaDeVeiculos.jsp");
        rd.forward(request, response);
        out.println("</body>");
        out.println("</html>");

    }
}
