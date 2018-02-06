package com.davidsegoviatomas.currencynewconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients("com.davidsegoviatomas.currencynewconversionservice")
public class CurrencyNewConversionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CurrencyNewConversionServiceApplication.class, args);
	}

	@Bean
    public AlwaysSampler defaultSampler() {
	    return new AlwaysSampler();
    }

}
