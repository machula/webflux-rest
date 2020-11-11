package com.machula.demo.controller;

import com.machula.demo.model.request.NodeRequest;
import com.machula.demo.model.response.NodeResponse;
import com.machula.demo.service.NodeService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/node")
public class NodeController {

    private final NodeService nodeService;

    public NodeController(NodeService nodeService) {
        this.nodeService = nodeService;
    }

    @GetMapping
    public Flux<NodeResponse> getNodeList(){
        return nodeService.findAll();
    }

    @PostMapping
    public Mono<NodeResponse> saveNode(@RequestBody NodeRequest request){
        return nodeService.save(request);
    }
}
