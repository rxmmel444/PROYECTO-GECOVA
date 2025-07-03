package com.pullconexiones.application.usercase;


import com.pullconexiones.domain.port.out.LoginServicePort;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AutenticacionUseCase {

    /*inyectamos al loginServePort y su constructor de donde viene el
    * metodo autenticar*/
    private final LoginServicePort servicePort;

    public AutenticacionUseCase(LoginServicePort servicePort) {
        this.servicePort = servicePort;
    }

/*Metodo autenticar que recibe el usuario y pasword
* va al metodo getoken para validar
* y retorna el mono con el token si es correcto */
    public Mono<String> autenticar (String user, String password){
        return servicePort.getToken(user,password);
    }
}
