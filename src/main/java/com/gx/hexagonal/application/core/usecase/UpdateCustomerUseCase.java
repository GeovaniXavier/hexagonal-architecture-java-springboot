package com.gx.hexagonal.application.core.usecase;

import com.gx.hexagonal.application.core.domain.Customer;
import com.gx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gx.hexagonal.application.ports.in.UpdateCustomerInputPort;
import com.gx.hexagonal.application.ports.out.FindAddresssByZipCodeOutputPort;
import com.gx.hexagonal.application.ports.out.UpdateCustomerOutputPort;

public class UpdateCustomerUseCase implements UpdateCustomerInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    public UpdateCustomerUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort, UpdateCustomerOutputPort updateCustomerOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.findAddresssByZipCodeOutputPort = findAddresssByZipCodeOutputPort;
        this.updateCustomerOutputPort = updateCustomerOutputPort;
    }

    @Override
    public void update(Customer customer, String zipCode) {
        findCustomerByIdInputPort.findCustomerById(customer.getId());
        var address = findAddresssByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        updateCustomerOutputPort.update(customer);

    }
}
