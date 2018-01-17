package com.yy.dream.core;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by lijingen on 2017/5/10.
 */
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.yy.dream")
public class CoreApplication {
    public static void main(String[] args) throws Exception {
        try {
            SpringApplication.run(CoreApplication.class, args);
            System.out.println("Spring boot initialize successful");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
