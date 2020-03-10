package com.concon.accountservice.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@EqualsAndHashCode(of="id")
@ToString
@Getter
@Setter
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

    @Column(value="created_at")
    private Date createdAt;

    @Column(value="is_active")
    private Boolean active;


    public Account() {
    }

    public Account(String id) {
        this.id = id;
    }

    public Account(String id, String username, String email, String password, Date createdAt, Boolean active) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.createdAt = createdAt;
        this.active = active;
    }
}
