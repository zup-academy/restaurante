package com.zcoders.restaurante.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurantes")
public class PedidoController {

    Logger logger = LoggerFactory.getLogger(PedidoController.class);

    @PutMapping("/{id}/pedidos/{idpedido}")
    public void aceitar(@PathVariable("id") Long id, @PathVariable("idpedido") Long idPedido){
        // primeiro confirmar se o id do restaurante é válido

        //segundo confirmar se existe no sistema de pedidos um pedido válido com esse id

        // terceiro atualizar pedido com status PREPARANDO

        logger.info("Pedido esta sendo preparado pelo Restaurante ");
    }
}
