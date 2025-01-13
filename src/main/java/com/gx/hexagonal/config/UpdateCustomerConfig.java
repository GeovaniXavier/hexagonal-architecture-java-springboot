package com.gx.hexagonal.config;

import com.gx.hexagonal.application.core.usecase.FindCustomerByIdUseCase;
import com.gx.hexagonal.application.core.usecase.UpdateCustomerUseCase;
import com.gx.hexagonal.application.ports.out.FindAddresssByZipCodeOutputPort;
import com.gx.hexagonal.application.ports.out.UpdateCustomerOutputPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UpdateCustomerConfig {

    @Bean
    public UpdateCustomerUseCase updateCustomerUseCase(FindCustomerByIdUseCase findCustomerByIdInputPort,
                                                       FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort,
                                                       UpdateCustomerOutputPort updateCustomerOutputPort) {

        return new UpdateCustomerUseCase(findCustomerByIdInputPort, findAddresssByZipCodeOutputPort, updateCustomerOutputPort);
    }

}
