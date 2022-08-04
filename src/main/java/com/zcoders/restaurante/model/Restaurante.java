package com.zcoders.restaurante.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeFantasia;

    private String documento;

    private String site;

    private String telefone;

    private LocalDateTime incluidoEm;

    private LocalDateTime atualizadoEm;

    public Restaurante() {
    }

    public Restaurante(String nomeFantasia, String documento, String site, String telefone) {
        this.nomeFantasia = nomeFantasia;
        this.documento = documento;
        this.site = site;
        this.telefone = telefone;
    }

    public Long getId() {
        return id;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public String getDocumento() {
        return documento;
    }

    public String getSite() {
        return site;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDateTime getIncluidoEm() {
        return incluidoEm;
    }

    public LocalDateTime getAtualizadoEm() {
        return atualizadoEm;
    }
}
