package com.buddhist.daily;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@Slf4j
@SpringBootApplication
public class ApplicationBoot {

    public static void main( String[] args ) {
        log.info("准备启动buddhist-daily ... ");
        SpringApplication.run(ApplicationBoot.class, args);
        log.info("启动buddhist-daily成功");
    }

    @Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }

}
