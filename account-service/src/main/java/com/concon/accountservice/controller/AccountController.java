package com.concon.accountservice.controller;

import com.concon.accountservice.service.AccountService;
import com.concon.client.contract.AccountDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


//projelerde direk baglanti olammali. implementation olarak islem yapilmasi daha saglikli
//instancenin olusmasi ve dis dünyaya acilmasi baska Http üzerinden methodlar yainlanmasi icin  @Restcontroller anotasyonu kiullaniyotruz
@RestController
@RequestMapping("account") // http üzerinde yayin yapacagimiz adresi belirlemek icin kullandigimiz anotation
@RequiredArgsConstructor
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


   @GetMapping("/{id}")
    public ResponseEntity<AccountDto> get(@PathVariable("id") String id){
     return ResponseEntity.ok(accountService.get(id));
    }
    @GetMapping("/accounts")
    public ResponseEntity<Slice<AccountDto>> getAll(Pageable pageable){
        return ResponseEntity.ok(accountService.findAll(pageable));
    }

    @PostMapping
    public ResponseEntity<AccountDto> save(@RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.save(account));
    }
    @PutMapping
    public ResponseEntity<AccountDto> update(@PathVariable("id") String id,@RequestBody AccountDto account){
        return ResponseEntity.ok(accountService.update(id,account));
    }
    @DeleteMapping
    public void delete(String id){
         accountService.delete(id);
    }


}
