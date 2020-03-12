package com.concon.client;

import lombok.Data;

import java.util.Date;

@Data
public class AccountDto {
    private String id;

    private String username;

    private String name;

    private String surname;

    private Date birthDate;

    private String email;

public String getNameSurname(){
    return this.name+" "+this.surname;
}
}