package com.zcoders.restaurante.listener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.zcoders.restaurante.model.Item;
import com.zcoders.restaurante.model.Pedido;
import com.zcoders.restaurante.model.StatusPedido;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class NovoPedidoEvent {

    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataCriado;

    private List<ItemEvent> itens;

    private StatusPedido status;

    public NovoPedidoEvent() {
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

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(LocalDateTime dataCriado) {
        this.dataCriado = dataCriado;
    }

    public List<ItemEvent> getItens() {
        return itens;
    }

    public void setItens(List<ItemEvent> itens) {
        this.itens = itens;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "NovoPedidoEvent{" +
                "id=" + id +
                ", idCliente=" + idCliente +
                ", idRestaurante=" + idRestaurante +
                ", dataCriado=" + dataCriado +
                ", itens=" + itens +
                '}';
    }

    public Pedido toModel() {
        return new Pedido(this.id, this.idCliente,
                this.idRestaurante, this.dataCriado, this.status);
    }
}
