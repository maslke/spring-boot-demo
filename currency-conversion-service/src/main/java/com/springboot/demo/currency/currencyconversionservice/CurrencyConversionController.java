package com.springboot.demo.currency.currencyconversionservice;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:maslke
 * @date:10/21/2018
 * @version:0.0.1
 */
@RestController
public class CurrencyConversionController {

    @Autowired
    private CurrencyExchangeServiceProxy proxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
    public CurrencyConversionBean retrieveCurrencyConversionBean(@PathVariable String from,
                                                                 @PathVariable String to,
                                                                 @PathVariable BigDecimal quantity) {
        CurrencyConversionBean response = proxy.retrieveConversionBean(from, to);
        return new CurrencyConversionBean(response.getId(), from, to, response.getConversionMultiple(), quantity,
                quantity.multiply(response.getConversionMultiple()), response.getPort());
    }
}
