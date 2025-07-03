package com.pullconexiones.domain.port.out;

import reactor.core.publisher.Mono;

/*El puerto de salida definimos el metodo
* para obtener el token de autenticacion
* solo interactua el caso de uso con esta interfaz*/
public  interface LoginServicePort {
    Mono<String> getToken(String user, String password);

}
