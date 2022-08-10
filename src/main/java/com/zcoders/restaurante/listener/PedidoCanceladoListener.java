package com.zcoders.restaurante.listener;

import com.zcoders.restaurante.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class PedidoCanceladoListener {

    Logger logger = LoggerFactory.getLogger(PedidoCanceladoListener.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.pedido-cancelado}" ,
            containerFactory = "pedidoCanceladoKafkaListenerContainerFactory")
    public void recebe(PedidoCanceladoEvent pedidoCanceladoEvent){

        logger.info("Evento PEDIDO CANCELADO lido com sucesso: {}", pedidoCanceladoEvent.toString());
    }

}
