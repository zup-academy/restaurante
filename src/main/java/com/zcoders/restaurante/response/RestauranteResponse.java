package com.zcoders.restaurante.response;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.zcoders.restaurante.model.Restaurante;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class RestauranteResponse {

    private Long id;

    private String nomeFantasia;

    private String documento;

    private String site;

    private String telefone;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    private LocalDateTime incluidoEm;

    @JsonFormat(pattern = "dd-MM-yyyy HH:MM:ss")
    private LocalDateTime atualizadoEm;

    public RestauranteResponse(Long id, String nomeFantasia, String documento,
                               String site, String telefone,
                               LocalDateTime incluidoEm, LocalDateTime atualizadoEm) {
        this.id = id;
        this.nomeFantasia = nomeFantasia;
        this.documento = documento;
        this.site = site;
        this.telefone = telefone;
        this.incluidoEm = incluidoEm;
        this.atualizadoEm = atualizadoEm;
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

    public static RestauranteResponse build(Restaurante restaurante) {
        return new RestauranteResponse(restaurante.getId(),
                restaurante.getNomeFantasia(), restaurante.getDocumento(),
                restaurante.getSite(), restaurante.getTelefone(),
                restaurante.getIncluidoEm(), restaurante.getAtualizadoEm());

    }
}
