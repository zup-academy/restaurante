package com.zcoders.restaurante.exception;

public class RestauranteExistenteException extends RuntimeException{

    public RestauranteExistenteException() {
        super("Já possuímos um cliente cadastrado em nossa base de dados com esse mesmo e-mail");
    }
}
