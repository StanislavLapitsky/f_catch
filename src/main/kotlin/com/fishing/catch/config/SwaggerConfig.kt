package com.fishing.catch.config

/**
 * @author stanislav.lapitsky created 7/4/2017.
 */
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.service.ApiInfo
import springfox.documentation.service.Contact
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

/**
 * @author stanislav.lapitsky created 4/12/2017.
 */
@Configuration
@EnableSwagger2
class SwaggerConfig {
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).groupName("f_catch-public-api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/")
                .apiInfo(apiInfo())
                .enableUrlTemplating(false)
    }

    private fun apiInfo(): ApiInfo {
        val apiInfo = ApiInfo(
                "Fishing Catch REST API",
                "Fishing Catch API.",
                "API 1.0",
                "No restrictions",
                Contact("", "", "some-email@a-test-company.com"),
                "No restrictions",
                "")
        return apiInfo
    }
}