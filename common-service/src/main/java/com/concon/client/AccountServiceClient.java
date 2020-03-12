package com.concon.client;

import com.concon.client.contract.AccountDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

//burada Accoun serviste konusmamiz gereken api methodlarinin tanimlari yer alacak
@FeignClient("account-service")//hangi servisle iletisim kuracagini yaziyoruz
public interface AccountServiceClient {
    @RequestMapping("account/{id}")
     ResponseEntity<AccountDto> get(@PathVariable("id") String id);
}
