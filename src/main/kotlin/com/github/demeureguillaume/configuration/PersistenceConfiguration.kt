package com.github.demeureguillaume.configuration

import org.springframework.context.annotation.Bean
import org.springframework.data.domain.AuditorAware
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.security.core.context.SecurityContextHolder


@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
class PersistenceConfig {

    @Bean
    internal fun auditorProvider(): AuditorAware<String> = object : AuditorAware<String> {
        override fun getCurrentAuditor(): String {
            return SecurityContextHolder.getContext().authentication.name
        }
    }

}