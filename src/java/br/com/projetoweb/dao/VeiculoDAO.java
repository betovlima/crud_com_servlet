package br.com.projetoweb.dao;

import br.com.projetoweb.model.Veiculo;
import java.util.List;

public interface VeiculoDAO {
    public List<Veiculo> listAll();
    public Veiculo getVeiculoById(Long id);
    public void updateRecord(Veiculo veiculo);

    public void insert(Veiculo veiculo);
}
