package com.zcoders.restaurante.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Pedido {

    @Id
    private Long id;

    private Long idCliente;

    private Long idRestaurante;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime dataCriado;

    @OneToMany(mappedBy = "pedido")
    private List<Item> items;

    public Pedido() {
    }

    public Pedido(Long id, Long idCliente, Long idRestaurante, LocalDateTime dataCriado, List<Item> items) {
        this.id = id;
        this.idCliente = idCliente;
        this.idRestaurante = idRestaurante;
        this.dataCriado = dataCriado;
        this.items = items;
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
