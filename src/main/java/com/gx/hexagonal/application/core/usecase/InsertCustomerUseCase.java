package com.gx.hexagonal.application.core.usecase;

import com.gx.hexagonal.application.core.domain.Customer;
import com.gx.hexagonal.application.ports.in.InsertCustomerInputPort;
import com.gx.hexagonal.application.ports.out.FindAddresssByZipCodeOutputPort;
import com.gx.hexagonal.application.ports.out.InsertCustomerOutputPort;
import com.gx.hexagonal.application.ports.out.SendCpfForValidationOutputPort;

public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort;

    private final InsertCustomerOutputPort insertCustomerOutputPort;

    private final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(FindAddresssByZipCodeOutputPort findAddresssByZipCodeOutputPort, InsertCustomerOutputPort insertCustomerOutputPort, SendCpfForValidationOutputPort sendCpfForValidationOutputPort) {
        this.findAddresssByZipCodeOutputPort = findAddresssByZipCodeOutputPort;
        this.insertCustomerOutputPort = insertCustomerOutputPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode) {
        var address = findAddresssByZipCodeOutputPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutputPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());
    }

}
