package com.davidsegoviatomas.currencyexchangeserver.controllers;

import com.davidsegoviatomas.currencyexchangeserver.model.ExchangeValue;
import com.davidsegoviatomas.currencyexchangeserver.repositories.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository repository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue getExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
        String port = environment.getProperty("local.server.port");
        if (port != null) exchangeValue.setPort(Integer.parseInt(port));
        return exchangeValue;
    }

}
