package com.concon.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import java.util.Date;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    @PrimaryKey
    private String id;

    private String username;

    private String name;

    private String surname;

    private Date birthDate;

    private String email;


}
