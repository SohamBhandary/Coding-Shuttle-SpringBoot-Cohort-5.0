package com.Soham.Module_4_Prod_Ready_features.AUth;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditoAwareImplem implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        //get securty contect,then authentication,priciple,username
        return Optional.of("Soham");
    }
}
