package by.it.restjwt.config;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SwaggerConfig {

    @Value("${nikolay.openapi.dev-url}")
    private String devUrl;

    @Bean
    public OpenAPI setOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Developer environment");
        Contact contact = new Contact();
        contact.setEmail("wulik1081@mail.ru");
        contact.setName("Nikolay");
        contact.setUrl("https://github.com/Nikolay1992167");
        License license1 = new License()
                .name("MIT LIcence")
                .url("https://choosealicense.com/license/mit/");
        Info info = new Info()
                .title("Rest Test API")
                .version("1.0")
                .contact(contact)
                .description("This API providers endpoints for management database of books and users protection via jwt-token");
        final String securitySchemeName = "bearerAuth";
        return new OpenAPI()
                .addSecurityItem(new SecurityRequirement()
                        .addList(securitySchemeName))
                .components(new Components()
                        .addSecuritySchemes(securitySchemeName, new SecurityScheme()
                                .name(securitySchemeName)
                                .type(SecurityScheme.Type.HTTP)
                                .scheme("bearer")
                                .bearerFormat("JWT")))
                .info(info)
                .servers(List.of(devServer));
    }
}
