package com.sl.api.admin.model;

import com.sl.api.admin.entity.Client;

public class ClientDto {

    Long id;
    Long code;
    String fullName;
    String phone;
    String email;

    public ClientDto() {

    }

    public ClientDto(Client client) {
        this.id = client.getId();
        this.code = client.getCode();
        this.fullName = client.getFullName();
        this.phone = client.getPhoneNumber();
        this.email = client.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
