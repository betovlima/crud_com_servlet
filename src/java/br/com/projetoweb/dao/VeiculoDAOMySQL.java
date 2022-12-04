package br.com.projetoweb.dao;

import br.com.projetoweb.config.DatabaseConnection;
import br.com.projetoweb.model.Veiculo;
import br.com.projetoweb.servlets.AlterarVeiculo;
import br.com.projetoweb.servlets.ListarVeiculos;
import br.com.projetoweb.utils.Utils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VeiculoDAOMySQL implements VeiculoDAO {

    @Override
    public List<Veiculo> listAll() {
        try ( Connection con = DatabaseConnection.initializeDatabase();  Statement st = con.createStatement();  ResultSet rs = st.executeQuery("SELECT * FROM veiculo");) {
            List<Veiculo> veiculos = new ArrayList<Veiculo>();
            while (rs.next()) {
                Veiculo veiculo = new Veiculo();
                veiculo.setId(rs.getLong("veiculoID"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setLugares(rs.getInt("lugares"));
                Double valorAluguel = rs.getDouble("valorAluguel");
                veiculo.setValorAluguel(rs.getDouble("valorAluguel"));
                String valorAluguelFormatado = Utils.getCurrencyValue(valorAluguel);
                veiculo.setValorAluguelFormatado(valorAluguelFormatado);
                veiculos.add(veiculo);
            }
            return veiculos;
        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Veiculo getVeiculoById(Long id) {
        try ( Connection con = DatabaseConnection.initializeDatabase();  Statement st = con.createStatement();  ResultSet rs = st.executeQuery("SELECT veiculoID,placa,modelo,marca,lugares,valorAluguel "
                + "FROM veiculo WHERE veiculoID = " + id);) {
            Veiculo veiculo = new Veiculo();
            while (rs.next()) {
                veiculo.setId(rs.getLong("veiculoID"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculo.setModelo(rs.getString("modelo"));
                veiculo.setMarca(rs.getString("marca"));
                veiculo.setLugares(rs.getInt("lugares"));
                veiculo.setValorAluguel(rs.getDouble("valorAluguel"));
            }
            return veiculo;
        } catch (SQLException ex) {
            Logger.getLogger(ListarVeiculos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void updateRecord(Veiculo veiculo) {
        Connection con = null;
        PreparedStatement st = null;
        try {
            con = DatabaseConnection.initializeDatabase();
            String update = "update "
                    + "veiculo set placa=?"
                    + ",modelo=?"
                    + ",marca=?"
                    + ",lugares=?"
                    + ",valorAluguel=?"
                    + " Where veiculoID=?";

            st = con.prepareStatement(update);
            st.setString(1, veiculo.getPlaca());
            st.setString(2, veiculo.getModelo());
            st.setString(3, veiculo.getMarca());
            st.setInt(4, veiculo.getLugares());
            st.setDouble(5, veiculo.getValorAluguel());
            st.setLong(6, veiculo.getId());
            st.executeUpdate();
        
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

    @Override
    public void insert(Veiculo veiculo) {
        Connection con = null;
        PreparedStatement st = null;
        try {

            con = DatabaseConnection.initializeDatabase();

            st = con
                    .prepareStatement("insert into "
                            + "veiculo(placa,modelo,marca,lugares,valorAluguel)values(?,?,?,?,?)");

            st.setString(1, veiculo.getPlaca());

            st.setString(2, veiculo.getModelo());

            st.setString(3, veiculo.getMarca());

            st.setInt(4, veiculo.getLugares());

            st.setDouble(5, veiculo.getValorAluguel());

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
                Logger.getLogger(VeiculoDAOMySQL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
