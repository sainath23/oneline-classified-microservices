package com.doitgeek.oc.usermanagementservice.model;

import java.io.Serializable;

public class PermissionModel implements Serializable {

    private static final long serialVersionUID = -7913307552100443960L;

    private Integer id;
    private String name;

    public PermissionModel() {
    }

    public PermissionModel(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
