package com.kkkoke;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author KeyCheung
 * @date 2023/06/29
 * @desc
 */
@Configurable
@EnableDubbo
@SpringBootApplication
public class LotterySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(LotterySystemApplication.class, args);
    }
}