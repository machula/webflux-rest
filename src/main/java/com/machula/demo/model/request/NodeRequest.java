package com.machula.demo.model.request;

import com.machula.demo.model.NodeDesc;
import com.machula.demo.model.NodeRoot;

public class NodeRequest {
    private NodeRoot nodeRoot;
    private NodeDesc nodeDesc;

    public NodeRequest() {
    }

    public NodeRequest(NodeRoot nodeRoot, NodeDesc nodeDesc) {
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
