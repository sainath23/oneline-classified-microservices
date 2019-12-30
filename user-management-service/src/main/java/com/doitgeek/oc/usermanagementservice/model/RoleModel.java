package com.doitgeek.oc.usermanagementservice.model;

import java.io.Serializable;
import java.util.Set;

public class RoleModel implements Serializable {

    private static final long serialVersionUID = -8955980301974296293L;

    private Integer id;
    private String name;
    private Set<PermissionModel> permissions;

    public RoleModel() {
    }

    public RoleModel(String name) {
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

    public Set<PermissionModel> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<PermissionModel> permissions) {
        this.permissions = permissions;
    }
}
