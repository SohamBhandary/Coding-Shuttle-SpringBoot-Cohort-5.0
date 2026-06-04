package com.Soham.Module_4_Prod_Ready_features.Config;

import com.Soham.Module_4_Prod_Ready_features.AUth.AuditoAwareImplem;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "getAuditorAware")
public class AppConfig {

    @Bean
    ModelMapper getModelMapper() {
        return new ModelMapper();
    }
    @Bean
    AuditorAware<String> getAuditorAware(){
        return new AuditoAwareImplem();
    }
}
