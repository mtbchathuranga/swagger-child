/*
 *
 *  Copyright 2015 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *
 */
package testApi;


import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Arrays;

import static java.util.Arrays.asList;
import static springfox.documentation.builders.PathSelectors.ant;

@EnableSwagger2
@Configuration
@Import(BeanValidatorPluginsConfiguration.class)
public class SwaggerConfig {

    @Bean
    public Docket restApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .securitySchemes(asList(
                        new BasicAuth("Basic AUTH"),
                        new OAuth(
                            "api_auth",
                            asList(new AuthorizationScope("write_api", "modify api"),
                                    new AuthorizationScope("read_api", "read your api")),
                                Arrays.<GrantType>asList(new ImplicitGrant(new LoginEndpoint("http://localhost:8080/auth"), "tokenName"))
                        ),
                        new ApiKey("api_key", "api_key", "header")
                ))
                .select()
                .paths(Predicates.and(ant("/**"), Predicates.not(ant("/error")), Predicates.not(ant("/management/**")), Predicates.not(ant("/management*"))))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Test Api")
                .description("Configure test API for development environment")
                .contact(new Contact("Buddhika Chathuranga", "http:/mtbchathuranga.com", "mtbchathuranga@gmail.com"))
                .license("slandered lichen")
                .licenseUrl("http://localhost:8080/lichen")
                .version("1.0.0")
                .build();
    }
}
