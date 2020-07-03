package com.filservtech.filipovcashapi;

import com.filservtech.filipovcashapi.config.property.CashApiProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(CashApiProperty.class)
public class FilipovCashApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FilipovCashApiApplication.class, args);
	}

}
