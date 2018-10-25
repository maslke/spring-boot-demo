package com.springboot.demo.forexservice.forexservice;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.then;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestPropertySource(properties = {"local.server.port=0"})
public class ForexServiceApplicationTests {

    @Autowired
    private TestRestTemplate testRestTemplate;

    //替换了 @Value("${local.server.port}")
    @LocalServerPort
    private int port;


    @Test
    public void contextLoads() {
    }

    @Test
    public void shouldReturn200WhenSendRequestToController() {
        ResponseEntity<ExchangeValue> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/currency-exchange/from/EUR/to/INR",
                ExchangeValue.class);
        then(entity.getStatusCode()).equals(HttpStatus.OK);
    }

    @Test
    public void shouldReturn200WhenSendRequestToActuator() {
        ResponseEntity<Map> entity = this.testRestTemplate.getForEntity("http://localhost:" + this.port + "/actuator/helth", Map.class);
        then(entity.getStatusCode()).equals(HttpStatus.OK);
    }


}
