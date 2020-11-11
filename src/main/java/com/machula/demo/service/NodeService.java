package com.machula.demo.service;

import com.machula.demo.model.request.NodeRequest;
import com.machula.demo.model.response.NodeResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface NodeService {
    Mono<NodeResponse> save(NodeRequest request);

    Flux<NodeResponse> findAll();
}
