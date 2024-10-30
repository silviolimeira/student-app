package com.sl.api.admin.entity;

import com.sl.api.admin.model.ClientDto;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "sl_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @Column(name = "code", unique = true)
    @NotEmpty
    Long code;

    @Column(name = "full_name")
    @NotEmpty
    private String fullName = "";

    @Column(name = "phone_number")
    private String phoneNumber = "";

    @Column(name = "email_client")
    @Email
    @NotEmpty
    private String email = "";

    public Client() { } 
    
    public Client(ClientDto dto) {
        this.id = dto.getId();
        this.code = dto.getCode();
        this.fullName = dto.getFullName();
        this.phoneNumber = dto.getPhone();
        this.email = dto.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotEmpty Long getCode() {
        return code;
    }

    public void setCode(@NotEmpty Long code) {
        this.code = code;
    }

    public @NotEmpty String getFullName() {
        return fullName;
    }

    public void setFullName(@NotEmpty String fullName) {
        this.fullName = fullName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public @Email @NotEmpty String getEmail() {
        return email;
    }

    public void setEmail(@Email @NotEmpty String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", code=" + code +
                ", fullName='" + fullName + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Client client = (Client) o;
        return code.equals(client.code);
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + code.hashCode();
        return result;
    }
}
