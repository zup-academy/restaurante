package com.zcoders.restaurante.listener;

public class PedidoCanceladoEvent {

    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    public PedidoCanceladoEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public Long getIdRestaurante() {
        return idRestaurante;
    }

    public void setIdRestaurante(Long idRestaurante) {
        this.idRestaurante = idRestaurante;
    }

    @Override
    public String toString() {
        return "PedidoCanceladoEvent{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                '}';
    }
}
