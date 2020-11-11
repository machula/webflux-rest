package com.machula.demo.model;

import java.util.Objects;

public class NodeDesc extends NodeRoot{
    private String description;

    public NodeDesc() {
    }

    public NodeDesc(NodeRoot nodeRoot, String description){
        super(nodeRoot.getId(), nodeRoot.getName());
        this.description = description;
    }

    public NodeDesc(String id, String name, String description) {
        super(id, name);
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        NodeDesc nodeDesc = (NodeDesc) o;
        return Objects.equals(description, nodeDesc.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), description);
    }
}
