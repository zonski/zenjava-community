package com.zenjava.community.service.impl.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "role")
@SequenceGenerator(name = "sequence_generator", sequenceName = "role_id_seq")
public class Role extends AbstractEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @ElementCollection
    @CollectionTable(name="role_permission", joinColumns = @JoinColumn(name = "role_id"))
    @Column(name = "permission")
    private Set<String> permissions;

    public Role() {
    }

    public Role(String name, String description, Set<String> permissions) {
        this.name = name;
        this.description = description;
        this.permissions = permissions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(Set<String> permissions) {
        this.permissions = permissions;
    }
}
