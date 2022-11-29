/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetoweb.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author roberto.lima
 */
public class DatabaseConnection {

    public static Connection initializeDatabase() {
        Connection con = null;
        try {
            String dbDriver = "com.mysql.cj.jdbc.Driver";
            String dbURL = "jdbc:mysql://localhost:3306/unisul?zeroDateTimeBehavior=CONVERT_TO_NULL";
            String dbUsername = "unisul";
            String dbPassword = "Un1s8!";

            Class.forName(dbDriver);

            con = DriverManager.getConnection(dbURL,
                    dbUsername,
                    dbPassword);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }
}
