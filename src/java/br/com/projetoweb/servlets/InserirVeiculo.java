package br.com.projetoweb.servlets;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
import br.com.projetoweb.config.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        Connection con = null;
        PreparedStatement st = null;
        try {

            con = DatabaseConnection.initializeDatabase();

            st = con
                    .prepareStatement("insert into " +
                             "veiculo(placa,modelo,marca,lugares,valorAluguel)values(?,?,?,?,?)");

            st.setString(1, request.getParameter("placa"));

            st.setString(2, request.getParameter("modelo"));

            st.setString(3, request.getParameter("marca"));

            st.setInt(4, Integer.parseInt(request.getParameter("lugares")));

            st.setDouble(5, Double.parseDouble(request.getParameter("valorAluguel")));

            st.executeUpdate();
           
            response.sendRedirect("listarVeiculos");
            
        } catch (IOException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
                st.close();
            } catch (SQLException ex) {
                Logger.getLogger(InserirVeiculo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
