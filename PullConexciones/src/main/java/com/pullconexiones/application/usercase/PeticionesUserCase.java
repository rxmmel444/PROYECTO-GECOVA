package com.pullconexiones.application.usercase;

import com.pullconexiones.domain.port.out.PeticionesServicePort;
import com.pullconexiones.infrastructure.adapter.in.dto.PeticionesRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PeticionesUserCase {

    private final PeticionesServicePort serviceImplPort;

    public PeticionesUserCase(PeticionesServicePort serviceImplPort) {
        this.serviceImplPort = serviceImplPort;
    }

    public Mono<PeticionesRequest> save (PeticionesRequest request){

        return serviceImplPort.save(request);
    }
}
