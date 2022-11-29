/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package br.com.projetoweb.servlets;

import br.com.projetoweb.config.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
@WebServlet("/excluirVeiculo")
public class ExcluirVeiculo extends HttpServlet {

    private String id;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        id = request.getParameter("veiculoID"); 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        id = (String) request.getParameter("veiculoID");
        try ( Connection con = DatabaseConnection.initializeDatabase();  Statement st = con.createStatement();) {
            String sql = "DELETE FROM veiculo WHERE veiculoID = " + id;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

        RequestDispatcher rd
                = request.getRequestDispatcher("listarVeiculos");
        rd.forward(request, response);

    }
}
