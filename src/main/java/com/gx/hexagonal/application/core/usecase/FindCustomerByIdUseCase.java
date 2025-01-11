package com.gx.hexagonal.application.core.usecase;

import com.gx.hexagonal.application.core.domain.Customer;
import com.gx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;

public class FindCustomerByIdUseCase implements FindCustomerByIdInputPort {

    private final FindCustomerByIdOutputPort findCustomerByIdOutputPort;

    public FindCustomerByIdUseCase(FindCustomerByIdOutputPort findCustomerByIdOutputPort) {
        this.findCustomerByIdOutputPort = findCustomerByIdOutputPort;
    }

    @Override
    public Customer findCustomerById(String id) {
        return findCustomerByIdOutputPort.findById(id).orElseThrow(() -> new RuntimeException("Customer not found"));
    }

}
