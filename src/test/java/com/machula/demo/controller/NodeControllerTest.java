package com.machula.demo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.machula.demo.model.NodeDesc;
import com.machula.demo.model.NodeRoot;
import com.machula.demo.model.request.NodeRequest;
import com.machula.demo.model.response.NodeResponse;
import com.machula.demo.service.NodeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebFluxTest
class NodeControllerTest {

    @Autowired
    WebTestClient webTestClient;

    @MockBean
    NodeService nodeService;

    @Test
    void getNodeList() {
        List<NodeResponse> nodeResponseList = new ArrayList<>();
        nodeResponseList.add(new NodeResponse(new NodeRoot("1", "node1"), new NodeDesc("1", "node1", "description 1")));
        nodeResponseList.add(new NodeResponse(new NodeRoot("2", "node2"), new NodeDesc("2", "node2", "description 2")));
        nodeResponseList.add(new NodeResponse(new NodeRoot("3", "node3"), new NodeDesc("3", "node3", "description 3")));
        nodeResponseList.add(new NodeResponse(new NodeRoot("4", "node4"), new NodeDesc("4", "node4", "description 4")));
        nodeResponseList.add(new NodeResponse(new NodeRoot("5", "node5"), new NodeDesc("5", "node5", "description 5")));

        Mockito.when(nodeService.findAll())
                .thenReturn(Flux.fromStream(nodeResponseList.stream()));

        webTestClient.get()
                .uri("/node")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .returnResult(NodeResponse.class);
    }

    @Test
    void saveNode() throws JsonProcessingException {
        NodeRoot nodeRoot = new NodeRoot("1", "node1");
        NodeDesc nodeDesc = new NodeDesc(nodeRoot, "description 1");

        NodeResponse nodeResponse = new NodeResponse(nodeRoot, nodeDesc);
        NodeRequest nodeRequest = new NodeRequest(nodeRoot, nodeDesc);

        Mockito.when(nodeService.save(Mockito.any(NodeRequest.class)))
                .thenReturn(Mono.just(nodeResponse));

        String responseBody = new String(Objects.requireNonNull(webTestClient.post()
                .uri("/node")
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(nodeRequest), NodeRequest.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody().returnResult().getResponseBody()));

        NodeResponse response = new ObjectMapper().readValue(responseBody, NodeResponse.class);

        Assertions.assertEquals(nodeResponse, response);
    }
}