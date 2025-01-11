package com.gx.hexagonal.application.core.usecase;

import com.gx.hexagonal.application.core.domain.Customer;
import com.gx.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gx.hexagonal.application.ports.out.FindAddresssByZipCodeOutputPort;
import com.gx.hexagonal.application.ports.out.InsertCustomerOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    public InsertCustomerUseCase(FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort) {
        this.findAddresssByZipCodeOutputPort = findAddresssByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddresssByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
    }

}
