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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.NumberFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@WebServlet("/alterarVeiculo")
public class AlterarVeiculo extends HttpServlet {

    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private Integer lugares;
    private Double valorAluguel;
    private String valorAluguelFormatado;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String veiculoID = request.getParameter("veiculoID");
        this.id = Long.valueOf(veiculoID);
        getVeiculo(this.id);
        request.setAttribute("veiculoID", this.id);
        request.setAttribute("placa", this.placa);
        request.setAttribute("modelo", this.modelo);
        request.setAttribute("marca", this.marca);
        request.setAttribute("lugares", this.lugares);
        request.setAttribute("valorAluguelFormatado", this.valorAluguelFormatado);
        
       RequestDispatcher requestDispatcher = request
                    .getRequestDispatcher("/AlterarVeiculos.jsp");
            requestDispatcher.forward(request, response); 

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        response.sendRedirect("listarVeiculos");
    }

    private void updateRecord() {
        Connection con = null;
        PreparedStatement st = null;
        try {

            con = DatabaseConnection.initializeDatabase();
            st = con.prepareStatement("update "
                    + "veiculo set placa=" + placa
                    + ",modelo=" + modelo
                    + ",marca=" + marca
                    + ",lugares=" + lugares
                    + ",valorAluguel=" + valorAluguel
                    + " Where veiculoID=" + id);

            st.executeUpdate();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(AlterarVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void getVeiculo(Long id) {
        try ( Connection con = DatabaseConnection.initializeDatabase();  Statement st = con.createStatement();  ResultSet rs = st.executeQuery("SELECT veiculoID,placa,modelo,marca,lugares,valorAluguel "
                + "FROM veiculo WHERE veiculoID = " + id);) {
            while (rs.next()) {
                this.id = rs.getLong("veiculoID");
                this.placa = rs.getString("placa");
                this.modelo = rs.getString("modelo");
                this.marca = rs.getString("marca");
                this.lugares = rs.getInt("lugares");
                this.valorAluguel = rs.getDouble("valorAluguel");
                this.valorAluguelFormatado = NumberFormat.getCurrencyInstance().format(rs.getDouble("valorAluguel"));
            }
            System.out.println("br.com.projetoweb.servlets.AlterarVeiculo.getVeiculo()");
        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
