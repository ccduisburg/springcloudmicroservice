package com.concon.accountservice.service;

import com.concon.accountservice.entity.Account;
import com.concon.accountservice.repository.AccountRepository;
import com.concon.client.AccountDto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.Optional;

// baska bir classta kullanabilmek icin @Component @Repository  olabilir di

@Service
public class AccountService {
    // Datayi veritabanindanmi veya kuyruk islemleri burda belirliyoruz.
    // Belki bu servisin altinda baskan servis katmanlari da eklenebilir

    private final AccountRepository accountRepository;
    private final ModelMapper modelMapper;

    public AccountService(AccountRepository accountRepository, ModelMapper modelMapper) {
        this.accountRepository = accountRepository;
        this.modelMapper = modelMapper;
    }

    public AccountDto get(String id){
        Account account=accountRepository.findById(id).orElseThrow(()->new IllegalArgumentException());
     return modelMapper.map(account, AccountDto.class);
    }
    @Transactional
    public AccountDto save(AccountDto accountDto){
        Account account=modelMapper.map(accountDto,Account.class);
        account= accountRepository.save(account);
        accountDto.setId(account.getId());
        return accountDto;
    }
    @Transactional
    public AccountDto update(String id,AccountDto accountDto){
        Assert.isNull(id,"Id cannot be null");
        Optional<Account> account=accountRepository.findById(id);
       Account accountToUpdate= account.map(it->{
            it.setBirthDate(accountDto.getBirthDate());
            it.setName(accountDto.getName());
            it.setSurname(accountDto.getSurname());
            return  it;
        }).orElseThrow(IllegalArgumentException::new);

      return  modelMapper.map(accountRepository.save(accountToUpdate),AccountDto.class);


    }
    @Transactional
    public void delete(String id){
        Account account=accountRepository.findById(id).orElseThrow(IllegalArgumentException::new);
        accountRepository.delete(account);
    }

    public Slice<AccountDto> findAll(Pageable pageable) {
        Slice<Account> accounts=accountRepository.findAll(pageable);

        return null;
    }
}
