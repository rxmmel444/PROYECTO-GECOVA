package com.pullconexiones.infrastructure.adapter.out.login;

import com.pullconexiones.domain.port.out.LoginServicePort;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;

@Component
public class LoginServiceAdapter implements LoginServicePort {

    /*inyectamos nuestro WebClient y generamos el constructor
    * que recibe un WebClientBuilder
    * la mapeamos al la instacia de nuestro Confi de WebCliente con el URL
    * del Microservicio a consumir */

    private final WebClient webClient;

    public LoginServiceAdapter(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://localhost:3001").build();
    }

    /*Metodo que reliza la peticion POST al enpoint de /auth/login*
    * del microservicio de Login ,mediante elo body value enviamos un ma con las
    * crendeciales del body
    * si es correcto
    * en bodyToMono devuelve el Token como String  */
    @Override
    public Mono<String> getToken(String user, String password) {
        return webClient.post()
                .uri("/auth/login")
                .bodyValue(Map.of("user",user,"password", password))
                .retrieve()
                .bodyToMono(String.class);
    }
}
