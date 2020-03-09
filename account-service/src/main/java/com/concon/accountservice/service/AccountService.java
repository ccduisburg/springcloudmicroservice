package com.concon.accountservice.service;

import com.concon.accountservice.entity.Account;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
// baska bir classta kullanabilmek icin @Component @Repository  olabilir di
@Service
public class AccountService {
    // Datayi veritabanindanmi veya kuyruk islemleri burda belirliyoruz.
    // Belki bu servisin altinda baskan servis katmanlari da eklenebilir
    public Account get(String id){
    return new Account("test-id");
    }
    public Account save(Account account){
        return new Account("test-id");
    }
    public Account update(Account account){
        return new Account("test-id");
    }
    public void delete(String id){

    }

}
