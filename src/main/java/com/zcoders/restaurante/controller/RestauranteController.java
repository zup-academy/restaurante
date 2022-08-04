package com.zcoders.restaurante.controller;

import com.zcoders.restaurante.exception.RestauranteExistenteException;
import com.zcoders.restaurante.exception.RestauranteInexistenteException;
import com.zcoders.restaurante.model.Restaurante;
import com.zcoders.restaurante.repository.RestauranteRepository;
import com.zcoders.restaurante.request.RestauranteRequest;
import com.zcoders.restaurante.response.RestauranteResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class RestauranteController {

    Logger logger = LoggerFactory.getLogger(RestauranteController.class);

    @Autowired
    private RestauranteRepository restauranteRepository;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public RestauranteResponse inserir(@RequestBody RestauranteRequest request){
        restauranteRepository.findByDocumento(request.getDocumento())
                .ifPresent(f -> {
                    throw new RestauranteExistenteException();});

        Restaurante restaurante = request.toModel();

        restauranteRepository.save(restaurante);

        logger.info("Restaurante novo incluído com o id {} ", restaurante.getId());

        return RestauranteResponse.build(restaurante);
    }

    @GetMapping("/{id}")
    public RestauranteResponse consultar(@PathVariable("id") Long id){
        Restaurante restaurante = restauranteRepository.findById(id)
                .orElseThrow(RestauranteInexistenteException::new);

        return RestauranteResponse.build(restaurante);
    }

}
