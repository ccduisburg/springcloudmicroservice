package com.concon.accountservice.dto;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.Date;

@Data
public class AccountDto {
    @PrimaryKey
    private String id;

    private String username;

    private String name;

    private String surname;

    private Date birthDate;

    private String email;


}


