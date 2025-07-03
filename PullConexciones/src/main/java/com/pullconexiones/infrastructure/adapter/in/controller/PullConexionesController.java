package com.pullconexiones.infrastructure.adapter.in.controller;

import com.pullconexiones.application.usercase.AutenticacionUseCase;
import com.pullconexiones.application.usercase.PeticionesUserCase;
import com.pullconexiones.infrastructure.adapter.in.dto.LoginRequest;
import com.pullconexiones.infrastructure.adapter.in.dto.PeticionesRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/conexion")
public class PullConexionesController {

    private final AutenticacionUseCase useCase;
    private final PeticionesUserCase useCasePeticion;

    public PullConexionesController(AutenticacionUseCase useCase, PeticionesUserCase useCasePeticion) {
        this.useCase = useCase;
        this.useCasePeticion = useCasePeticion;
    }

    /*ENDPOINT PARA CESAR -> MICROSERVICIO LOGIN*/

    @PostMapping("/login2")
    public Mono<ResponseEntity<String>> login(@RequestBody LoginRequest request) {

        /*
        String token = useCase.autenticar(request.getUser(),request.getPassword());
        return ResponseEntity.ok(token);
        */

        /*recibimos la peticion mediante el LoginRequest
        Llamamos al metodo autenticar del caso de uso pasandole los parametro
        * si las credenciales son correctas, retorna el MONO con el token generado
        * y lo devolvemos un ResponseEntity con el 200 OK*/
        return useCase.autenticar(request.getUser(), request.getPassword())
                .map(token -> ResponseEntity.ok(token));
    }


    @PostMapping("/peticion")
    public Mono<ResponseEntity<PeticionesRequest>> crearPeticion(@RequestBody PeticionesRequest peticionesRequest){

        return useCasePeticion.save(peticionesRequest)
                .map(saved -> ResponseEntity.status(HttpStatus.CREATED).body(saved));


    }

}


