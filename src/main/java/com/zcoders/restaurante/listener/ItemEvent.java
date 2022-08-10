package com.zcoders.restaurante.listener;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.zcoders.restaurante.model.Item;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ItemEvent {

    private Long id;

    private int quantidade;

    private Long sku;

    private BigDecimal valor;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
    private LocalDateTime dataCriado;

    public ItemEvent() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Long getSku() {
        return sku;
    }

    public void setSku(Long sku) {
        this.sku = sku;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public LocalDateTime getDataCriado() {
        return dataCriado;
    }

    public void setDataCriado(LocalDateTime dataCriado) {
        this.dataCriado = dataCriado;
    }

    @Override
    public String toString() {
        return "ItemEvent{" +
                "id=" + id +
                ", quantidade=" + quantidade +
                ", sku=" + sku +
                ", valor=" + valor +
                ", dataCriado=" + dataCriado +
                '}';
    }


    public Item toModel() {
        return new Item(this.id, this.quantidade, this.sku, this.valor, this.dataCriado);
    }
}
