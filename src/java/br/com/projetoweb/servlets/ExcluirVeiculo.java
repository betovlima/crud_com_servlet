package br.com.projetoweb.servlets;

import br.com.projetoweb.config.DatabaseConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
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
        response.setIntHeader("Refresh", 5);

        // Set response content type
        response.setContentType("text/html");
        id = (String) request.getParameter("veiculoID");
        try ( Connection con = DatabaseConnection.initializeDatabase();  Statement st = con.createStatement();) {
            String sql = "DELETE FROM veiculo WHERE veiculoID = " + id;
            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }

        String redirect
                = response.encodeRedirectURL(request.getContextPath() + "/ListaVeiculos.jsp");
        response.sendRedirect(redirect);

    }
}
