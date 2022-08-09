package com.zcoders.restaurante.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Item {

    @Id
    private Long id;

    private int quantidade;

    private Long sku;

    private BigDecimal valor;

    private LocalDateTime dataCriado;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido;

    public Item() {
    }

    public Item(Long id, int quantidade, Long sku, BigDecimal valor, LocalDateTime dataCriado) {
        this.id = id;
        this.quantidade = quantidade;
        this.sku = sku;
        this.valor = valor;
        this.dataCriado = dataCriado;
    }


}
