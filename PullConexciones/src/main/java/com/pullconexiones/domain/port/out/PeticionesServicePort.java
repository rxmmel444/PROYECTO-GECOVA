package com.pullconexiones.domain.port.out;

import com.pullconexiones.infrastructure.adapter.in.dto.PeticionesRequest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PeticionesServicePort {

    public Flux<PeticionesRequest> findAll();
    public Mono<PeticionesRequest> findById(Long id);
    public Mono<PeticionesRequest>  save (PeticionesRequest peticion);
    public Mono<PeticionesRequest>  update (PeticionesRequest peticion, Long id);
    public Mono<PeticionesRequest>  delete  (Long id);
}
