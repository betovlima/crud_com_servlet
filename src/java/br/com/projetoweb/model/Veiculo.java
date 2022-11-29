/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projetoweb.model;

/**
 *
 * @author roberto.lima
 */
public class Veiculo {

    private Long id;
    private String placa;
    private String modelo;
    private String marca;
    private Integer lugares;
    private Double valorAluguel;
    private String valorAluguelFormatado;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getLugares() {
        return lugares;
    }

    public void setLugares(Integer lugares) {
        this.lugares = lugares;
    }

    public Double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(Double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public String getValorAluguelFormatado() {
        return valorAluguelFormatado;
    }

    public void setValorAluguelFormatado(String valorAluguelFormatado) {
        this.valorAluguelFormatado = valorAluguelFormatado;
    }

}
