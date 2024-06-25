package com.Bankify.Cards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Bankify Application- Cards Service REST API Documentation",
                description = "detailed documentation of all card service endpoints ",
                version = "V1",
                contact = @Contact(
                        name = "Sridhar Vadla",
                        url = "https://github.com/SridharVadla45/",
                        email = "dummy@gmail.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url="https://github.com/SridharVadla45/"
                )

        )
)
public class CardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(CardsApplication.class, args);
    }

}
