package com.zcoders.restaurante.exception;

public class RestauranteInexistenteException extends RuntimeException{

    public RestauranteInexistenteException() {
        super("Não encontramos cliente cadastrado em nossa base de dados com esse id");
    }
}
