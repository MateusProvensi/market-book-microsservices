package com.provensi.configuration;

import java.util.ArrayList;
import java.util.List;

import org.springdoc.core.models.GroupedOpenApi;
import org.springdoc.core.properties.SwaggerUiConfigParameters;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@Configuration
@OpenAPIDefinition(info = @Info(title = "API Gateway Service API", version = "v1", description = "Documention of API Gateway API"))
public class OpenApiConfiguration {

	@Bean
	@Lazy(false)
	public List<GroupedOpenApi> apis(
			SwaggerUiConfigParameters config,
			RouteDefinitionLocator locator) {
		List<GroupedOpenApi> groups = new ArrayList<>();
		List<RouteDefinition> definitions = locator.getRouteDefinitions().collectList().block();

		definitions.stream().filter(routeDefinition -> routeDefinition.getId().matches(".*-service"))
				.forEach(routeDefinition -> {
					String name = routeDefinition.getId();
					
					config.addGroup(name);
					
					GroupedOpenApi.builder().pathsToMatch("/" + name + "/**").group(name).build();
				});

		return groups;
	}

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components())
				.info(new io.swagger.v3.oas.models.info.Info().title("API Gateway").version("v1")
						.license(new License().name("Apache 2.0").url("http://springdov.org")));
	}

}
