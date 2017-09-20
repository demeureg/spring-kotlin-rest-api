package com.github.demeureguillaume.configuration

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.web.filter.ShallowEtagHeaderFilter
import springfox.documentation.builders.PathSelectors
import springfox.documentation.builders.RequestHandlerSelectors
import springfox.documentation.spi.DocumentationType
import springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration
import springfox.documentation.spring.web.plugins.Docket
import springfox.documentation.swagger2.annotations.EnableSwagger2

@Configuration
@EnableSwagger2
@Import(*arrayOf(SpringDataRestConfiguration::class))
class RestConfiguration {

    @Bean
    internal fun api() : Docket = Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()

    @Bean
    internal fun shallowEtagHeaderFilter() : ShallowEtagHeaderFilter = ShallowEtagHeaderFilter()
}