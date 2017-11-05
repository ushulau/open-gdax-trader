package com.gplex.open.trader.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gplex.open.trader.constant.Const;
import com.gplex.open.trader.domain.OrderResponse;
import com.gplex.open.trader.utils.Utils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Vlad S. on 9/15/17.
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@TestPropertySource("classpath:gdax-keys.properties")
public class OrderServiceImplTestHarness {
    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImplTestHarness.class);

    @Autowired
    private AccountsServiceImpl os;
    @Autowired
    private OrderServiceImpl orderService;



    @Test
    public void testOrder() throws JsonProcessingException {
        for(int i = 0; i <= 100; i++) {
            OrderResponse response = orderService.buyOrder(Const.Products.BTC_USD, Utils.round(Math.random() * 10000.0), 1.0);
            OrderResponse sellResponse = orderService.sellOrder(Const.Products.BTC_USD, Utils.round(Math.random() * 10000.0  + 1000.0) , 1.0);
            logger.debug("\n{}\n{}", new Object[]{Utils.MAPPER.writeValueAsString(response),Utils.MAPPER.writeValueAsString(sellResponse) });
        }


    }



}