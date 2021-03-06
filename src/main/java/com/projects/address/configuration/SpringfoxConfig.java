package com.projects.address.configuration;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.ResponseMessage;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger.web.UiConfigurationBuilder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Configuration
@EnableSwagger2
public class SpringfoxConfig {

//  @Value("${spring.application.name}")
  private String applicationName;

  //@Value("${spring.profiles.active}")
  private String profile;

/*  @Bean
  public Docket gatewayApi() {
    return new Docket(DocumentationType.SWAGGER_2)
        .select()
        .apis(RequestHandlerSelectors.any())
        .paths(PathSelectors.regex("/api/.*"))
        .build()
        .pathMapping(getPathMapping(profile))
        .useDefaultResponseMessages(false)
        .globalResponseMessage(RequestMethod.POST, defaultErrorsMessage())
        .apiInfo(apiInfo());
  }*/

  private List<ResponseMessage> defaultErrorsMessage() {
    return Lists.newArrayList(
        new ResponseMessageBuilder().code(NOT_FOUND.value()).message("Data not found").build(),
        new ResponseMessageBuilder()
            .code(INTERNAL_SERVER_ERROR.value())
            .message("Internal error on fb-chargeback")
            .build(),
        new ResponseMessageBuilder()
            .code(BAD_REQUEST.value())
            .message("Invalid json / json")
            .build(),
        new ResponseMessageBuilder()
            .code(BAD_GATEWAY.value())
            .message("Electronic Authorizer")
            .build());
  }

  private ApiInfo apiInfo() {
    return new ApiInfoBuilder().title("Address").description("Users").version("1.0").build();
  }

  @Bean
  public UiConfiguration uiConfig() {
    return UiConfigurationBuilder.builder().build();
  }

  private String getPathMapping(String profile) {
    String pathMapping = "";
    if (!profile.equalsIgnoreCase("local")) {
      return pathMapping.concat(applicationName);
    }
    return pathMapping;
  }
}
