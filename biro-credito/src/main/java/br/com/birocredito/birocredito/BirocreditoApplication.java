package br.com.birocredito.birocredito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class BirocreditoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BirocreditoApplication.class, args);
	}

}
