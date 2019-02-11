package com.estheto.esms.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public enum Role {

    ADMIN("ADMIN"), STUDENT("STUDENT"), TEACHER("TEACHER");

    @Id
    String value;

    Role(String roleName) {
        this.value = roleName;
    }

    public String getValue() {
        return value;
    }
}
