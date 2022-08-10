package com.zcoders.restaurante.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Pedido {

    @Id
    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriado;


    @Enumerated(EnumType.STRING)
    private StatusPedido status;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, Long idRestaurante, LocalDateTime dataCriado, StatusPedido status) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.dataCriado = dataCriado;
        this.status = status;
    }

    public void cancelar() {
        this.status = StatusPedido.CANCELADO;
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                ", dataCriado=" + dataCriado +
                '}';
    }

}
