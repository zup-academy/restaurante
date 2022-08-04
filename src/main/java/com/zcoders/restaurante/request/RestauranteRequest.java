package com.zcoders.restaurante.request;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zcoders.restaurante.model.Restaurante;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RestauranteRequest {

    private String nomeFantasia;

    private String documento;

    private String site;

    private String telefone;

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public Restaurante toModel() {
        return new Restaurante(this.nomeFantasia, this.documento, this.site, this.telefone);
    }
}
