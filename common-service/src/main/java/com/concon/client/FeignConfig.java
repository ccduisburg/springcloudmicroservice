package com.concon.client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;
//sadece bir konfigrasyondur tüm projede feign client enable etmesi icin
// ticket servis ve account serviste de aktif hale getirilecek
@Configuration
@EnableFeignClients
public class FeignConfig {
}
