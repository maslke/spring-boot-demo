package com.springboot.demo.forexservice.forexservice;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author:maslke
 * @date:10/20/2018
 * @version:0.0.1
 */
public interface ExchangeValueRepository extends JpaRepository<ExchangeValue, Long> {
    ExchangeValue findByFromAndTo(String from, String to);
}
