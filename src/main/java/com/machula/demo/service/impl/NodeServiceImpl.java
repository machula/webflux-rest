package com.machula.demo.service.impl;

import com.machula.demo.entity.NodeEntity;
import com.machula.demo.model.NodeDesc;
import com.machula.demo.model.NodeRoot;
import com.machula.demo.model.request.NodeRequest;
import com.machula.demo.model.response.NodeResponse;
import com.machula.demo.repository.NodeRepository;
import com.machula.demo.service.NodeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class NodeServiceImpl implements NodeService {

    private final NodeRepository nodeRepository;

    public NodeServiceImpl(NodeRepository nodeRepository) {
        this.nodeRepository = nodeRepository;
    }

    @Override
    public Mono<NodeResponse> save(final NodeRequest request) {
        Mono<NodeEntity> nodeEntityMono = nodeRepository.save(convertNodeRequestToNodeEntity(request));

        return nodeEntityMono.map(this::convertNodeEntityToNodeResponse);
    }

    @Override
    public Flux<NodeResponse> findAll() {
        return nodeRepository.findAll().map(this::convertNodeEntityToNodeResponse);
    }

    private NodeEntity convertNodeRequestToNodeEntity(final NodeRequest request){
        NodeRoot nodeRoot = request.getNodeRoot();

        NodeDesc nodeDesc = request.getNodeDesc();
        nodeDesc.setId(nodeRoot.getId());
        nodeDesc.setName(nodeRoot.getName());

        return new NodeEntity(nodeRoot, nodeDesc);
    }

    private NodeResponse convertNodeEntityToNodeResponse(final NodeEntity nodeEntity){
        return new NodeResponse(nodeEntity.getNodeRoot(), nodeEntity.getNodeDesc());
    }
}
