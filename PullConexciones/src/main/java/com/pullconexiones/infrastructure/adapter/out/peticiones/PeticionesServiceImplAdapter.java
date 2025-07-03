package com.pullconexiones.infrastructure.adapter.out.peticiones;

import com.pullconexiones.domain.port.out.PeticionesServicePort;
import com.pullconexiones.infrastructure.adapter.in.dto.PeticionesRequest;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Component
public class PeticionesServiceImplAdapter implements PeticionesServicePort {


    private final WebClient webClient;

    public PeticionesServiceImplAdapter(WebClient.Builder webClient) {
        this.webClient = webClient.baseUrl("http://localhost:3002").build();

    }

    @Override
    public Flux<PeticionesRequest> findAll() {
        return null;
    }

    @Override
    public Mono<PeticionesRequest> findById(Long id) {
        return null;
    }

    @Override
    public Mono<PeticionesRequest> save(PeticionesRequest peticion) {
        return webClient.post()
                .uri("/peticion")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(peticion)
                .retrieve()
                .bodyToMono(PeticionesRequest.class);
    }

    @Override
    public Mono<PeticionesRequest> update(PeticionesRequest peticion, Long id) {
        return null;
    }

    @Override
    public Mono<PeticionesRequest> delete(Long id) {
        return null;
    }
}
