package com.concon.accountservice.entity;

import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.UUID;

@EqualsAndHashCode(of="id")
@ToString
@Table(value="accounts")
public class Account implements Serializable {
    @PrimaryKey
    private String id= UUID.randomUUID().toString();
    @Column(value="uname")
    private String username;
    @Column(value="email")
    private String email;
    @Column(value="pwd")
    private String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Account(String id, String username, String email, String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public Account() {
    }

    public Account(String id) {
        this.id = id;
    }
}
