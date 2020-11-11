package com.machula.demo.model;

import java.util.Objects;

public class NodeRoot {
    private String id;
    private String name;

    public NodeRoot() {
    }

    public NodeRoot(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NodeRoot nodeRoot = (NodeRoot) o;
        return Objects.equals(id, nodeRoot.id) &&
                Objects.equals(name, nodeRoot.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
