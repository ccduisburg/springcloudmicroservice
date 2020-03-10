package com.concon.accountservice.service;

import com.concon.accountservice.entity.Account;
import com.concon.accountservice.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

// baska bir classta kullanabilmek icin @Component @Repository  olabilir di
@RequiredArgsConstructor
@Service
public class AccountService {
    // Datayi veritabanindanmi veya kuyruk islemleri burda belirliyoruz.
    // Belki bu servisin altinda baskan servis katmanlari da eklenebilir

    private final AccountRepository accountRepository;


    public Account get(String id){
     return accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
    }
    public Account save(Account account){
        return accountRepository.save(account);
    }
    public Account update(String id,Account account){
        Assert.isNull(id,"Id cennot be null");
        return accountRepository.save(account);
    }
    public void delete(String id){

    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }
}
