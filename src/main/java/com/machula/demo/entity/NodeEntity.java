package com.machula.demo.entity;

import com.machula.demo.model.NodeDesc;
import com.machula.demo.model.NodeRoot;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "node")
public class NodeEntity {
    private NodeRoot nodeRoot;
    private NodeDesc nodeDesc;

    public NodeEntity() {
    }

    public NodeEntity(NodeRoot nodeRoot, NodeDesc nodeDesc) {
        this.nodeRoot = nodeRoot;
        this.nodeDesc = nodeDesc;
    }

    public NodeRoot getNodeRoot() {
        return nodeRoot;
    }

    public void setNodeRoot(NodeRoot nodeRoot) {
        this.nodeRoot = nodeRoot;
    }

    public NodeDesc getNodeDesc() {
        return nodeDesc;
    }

    public void setNodeDesc(NodeDesc nodeDesc) {
        this.nodeDesc = nodeDesc;
    }
}
