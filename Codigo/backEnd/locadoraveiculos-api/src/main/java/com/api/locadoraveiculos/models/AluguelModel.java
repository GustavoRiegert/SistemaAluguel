package com.api.locadoraveiculos.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "aluguel")
public class AluguelModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Column(nullable = false, length = 150)
    private String automovel;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    private ClienteModel cliente;
    @Column(nullable = false, length = 150)
    private String statusContrato;
    @Column(nullable = false, length = 150)
    private String dataInicio;

    @Column(nullable = true, length = 150)
    private String dataFim;

    @Column(nullable = false)
    private double valorAluguel;

    @Column(nullable = false)
    private double valorCaucao;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

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
