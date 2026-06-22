package com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Services.Imple;

import com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Services.DataService;
import lombok.Data;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("prod")
public class DataServiceImpleProd implements DataService {
    @Override
    public String getData() {
        return "From Production code";
    }
}
