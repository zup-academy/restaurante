package com.zcoders.restaurante.listener;

import com.zcoders.restaurante.model.Item;
import com.zcoders.restaurante.model.Pedido;
import com.zcoders.restaurante.repository.ItemRepository;
import com.zcoders.restaurante.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class NovoPedidoListener {

    Logger logger = LoggerFactory.getLogger(NovoPedidoListener.class);

    @Autowired
    PedidoRepository pedidoRepository;

    @Autowired
    ItemRepository itemRepository;

    @KafkaListener(topics = "${spring.kafka.consumer.topic.novo-pedido}")
    public void recebe(NovoPedidoEvent novoPedidoEvent ){

        Pedido pedido = novoPedidoEvent.toModel();
        pedidoRepository.save(pedido);

        List<Item> itens = novoPedidoEvent.getItens()
                .stream().map(i -> i.toModel()).collect(Collectors.toList());
        itemRepository.saveAll(itens);

        logger.info("Evento lido com sucesso idCompra: {}", novoPedidoEvent.toString());
    }
}
