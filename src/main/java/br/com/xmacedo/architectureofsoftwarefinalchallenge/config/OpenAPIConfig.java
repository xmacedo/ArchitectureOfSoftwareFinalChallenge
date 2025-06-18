package br.com.xmacedo.architectureofsoftwarefinalchallenge.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Gerenciamento de Clientes")
                        .version("1.0")
                        .description("API para gerenciamento de clientes do sistema")
                        .contact(new Contact()
                                .name("Felipe Macedo")
                                .email("felipe.x.macedo@gmail.com")));
    }
}
