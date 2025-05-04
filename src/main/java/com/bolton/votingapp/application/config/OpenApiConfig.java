package com.bolton.votingapp.application.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
  info = @Info(
    title = "Todo Management API",
    version = "1.0.0",
    description = "A code‑first example with Springdoc and Swagger UI",
    contact = @Contact(name = "Your Name", email = "you@example.com"),
    license = @License(name = "MIT", url = "https://opensource.org/licenses/MIT")
  ),
  servers = @Server(url = "http://localhost:8080")
)
public class OpenApiConfig {
}