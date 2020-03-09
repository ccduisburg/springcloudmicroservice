package com.concon.accountservice.controller;

import com.concon.accountservice.entity.Account;
import com.concon.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//projelerde direk baglanti olammali. implementation olarak islem yapilmasi daha saglikli
//instancenin olusmasi ve dis dünyaya acilmasi baska Http üzerinden methodlar yainlanmasi icin  @Restcontroller anotasyonu kiullaniyotruz
@RestController
@RequestMapping("account") // http üzerinde yayin yapacagimiz adresi belirlemek icin kullandigimiz anotation
public class AccountController {
/**
* localhost:8080/account
 * GET PUT DELETE POST HEAD
*/
// Eger birden fazla save methodu kullanilacaksa alt adresler olusturulmasi gerekir. Normalde root adres te tek method icin adres yazmaya gerek yok

//    @Autowired // inject yapmak icin kullanilyior
//    private AccountService accountService=new AccountService();
    //yaptigi is acisindan yukaridaki @Autowired anotation örnegindenfarkli degildir
    private final AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

   @GetMapping("/{id}")
    public ResponseEntity<Account> get(@PathVariable("id") String id){
     return ResponseEntity.ok(accountService.get(id));
    }
    @PostMapping
    public ResponseEntity<Account> save(@RequestBody Account account){
        return ResponseEntity.ok(accountService.save(account));
    }
    @PutMapping
    public ResponseEntity<Account> update(Account account){
        return ResponseEntity.ok(accountService.update(account));
    }
    @DeleteMapping
    public void delete(String id){
         accountService.delete(id);
    }


}
