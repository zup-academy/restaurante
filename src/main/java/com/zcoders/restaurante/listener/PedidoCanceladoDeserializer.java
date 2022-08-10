package com.zcoders.restaurante.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

public class PedidoCanceladoDeserializer implements Deserializer<PedidoCanceladoEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public PedidoCanceladoEvent deserialize(String s, byte[] data) {
        try {
            System.out.println("AAAAAAAAAAA");
            return objectMapper.readValue(data, PedidoCanceladoEvent.class);
        } catch (IOException e) {
            System.out.println("BBBBBBBBBBBBB");
            throw new SerializationException(e);
        }
    }
}
