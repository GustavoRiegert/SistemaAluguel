package com.api.locadoraveiculos.dtos;

import com.api.locadoraveiculos.models.ClienteModel;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.UUID;

public class AluguelDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotNull
    private String automovel;

    private ClienteModel cliente;
    @NotNull
    private String statusContrato;
    @NotNull
    private String dataInicio;

    @NotNull
    private String dataFim;

    @NotNull
    private double valorAluguel;

    @NotNull
    private double valorCaucao;

    public String getAutomovel() {
        return automovel;
    }

    public void setAutomovel(String automovel) {
        this.automovel = automovel;
    }

    public ClienteModel getCliente() {
        return cliente;
    }

    public void setCliente(ClienteModel cliente) {
        this.cliente = cliente;
    }

    public String getStatusContrato() {
        return statusContrato;
    }

    public void setStatusContrato(String statusContrato) {
        this.statusContrato = statusContrato;
    }

    public String getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(String dataInicio) {
        this.dataInicio = dataInicio;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public double getValorAluguel() {
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel) {
        this.valorAluguel = valorAluguel;
    }

    public double getValorCaucao() {
        return valorCaucao;
    }

    public void setValorCaucao(double valorCaucao) {
        this.valorCaucao = valorCaucao;
    }
}
