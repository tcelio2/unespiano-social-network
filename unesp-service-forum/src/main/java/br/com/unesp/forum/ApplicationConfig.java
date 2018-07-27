package br.com.unesp.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan({"br.com.unesp.forum"})
public class ApplicationConfig {

  public static void main(String[] args) {
    SpringApplication.run(ApplicationConfig.class, args);
  }

//  @RequestMapping("/forum")
//  public String greeting() {
//      return "hello from FORUM!";
//  }
}