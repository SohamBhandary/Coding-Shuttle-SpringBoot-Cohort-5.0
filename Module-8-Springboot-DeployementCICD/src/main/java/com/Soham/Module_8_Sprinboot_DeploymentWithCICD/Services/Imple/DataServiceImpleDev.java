package com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Services.Imple;

import com.Soham.Module_8_Sprinboot_DeploymentWithCICD.Services.DataService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("dev")
public class DataServiceImpleDev implements DataService {
    @Override
    public String getData() {
        return "From Dev Enviroment";
    }
}
