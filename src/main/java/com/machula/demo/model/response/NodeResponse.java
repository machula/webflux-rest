package com.machula.demo.model.response;

import com.machula.demo.model.NodeDesc;
import com.machula.demo.model.NodeRoot;

import java.util.Objects;

public class NodeResponse {
    private NodeRoot nodeRoot;
    private NodeDesc nodeDesc;

    public NodeResponse() {
    }

    public NodeResponse(NodeRoot nodeRoot, NodeDesc nodeDesc) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeResponse response = (NodeResponse) o;
        return Objects.equals(nodeRoot, response.nodeRoot) &&
                Objects.equals(nodeDesc, response.nodeDesc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nodeRoot, nodeDesc);
    }
}
