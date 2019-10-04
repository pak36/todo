package com.coinone.api.web

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.ApiInfoBuilder
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.swagger2.annotations.EnableSwagger2
import springfox.documentation.spring.web.plugins.Docket

@Configuration
@EnableSwagger2
class SwaggerConfiguration {

    @Bean
    open fun api(): Docket = Docket(DocumentationType.SWAGGER_2)
            .select()
            .apis(RequestHandlerSelectors.basePackage("com.coinone.api"))
            .paths(PathSelectors.any())
            .build()
            .apiInfo(this.metaInfo())

    private fun metaInfo(): ApiInfo {
        return ApiInfoBuilder()
                .title("Todo API 문서")
                .description("Todo API 문서로 테스트입니다.")
                .version("1.0")
                .termsOfServiceUrl("http://localhost:8080")
                .license("Apache")
                .licenseUrl("http://localhost:8080")
                .contact(
                        Contact(
                                "JunePark",
                                "http://",
                        "junepark@coinone.com"
                        )
                )
                .build()

    }
}