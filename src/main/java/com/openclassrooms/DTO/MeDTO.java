package com.openclassrooms.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.openclassrooms.model.AuditTable;

import java.util.Date;

public class MeDTO extends AuditTable {

    private Integer id;
    private String name;
    private String email;


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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
