package com.zcoders.restaurante.listener;

import com.zcoders.restaurante.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class NovoPedidoListener {

    Logger logger = LoggerFactory.getLogger(NovoPedidoListener.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.novo-pedido}")
    public void recebe( ){

        logger.info("Evento lido com sucesso idCompra: {}");
    }
}
