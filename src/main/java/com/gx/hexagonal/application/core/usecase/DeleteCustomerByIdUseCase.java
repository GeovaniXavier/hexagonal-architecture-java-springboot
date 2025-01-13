package com.gx.hexagonal.application.core.usecase;

import com.gx.hexagonal.application.ports.in.DeleteCustomerByIdInputPort;
import com.gx.hexagonal.application.ports.in.FindCustomerByIdInputPort;
import com.gx.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;

public class DeleteCustomerByIdUseCase implements DeleteCustomerByIdInputPort {

    private final FindCustomerByIdInputPort findCustomerByIdInputPort;

    private final DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort;

    public DeleteCustomerByIdUseCase(FindCustomerByIdInputPort findCustomerByIdInputPort, DeleteCustomerByIdOutputPort deleteCustomerByIdOutputPort) {
        this.findCustomerByIdInputPort = findCustomerByIdInputPort;
        this.deleteCustomerByIdOutputPort = deleteCustomerByIdOutputPort;
    }

    @Override
    public void deleteById(String id) {
        findCustomerByIdInputPort.findCustomerById(id);
        deleteCustomerByIdOutputPort.deleteCustomerById(id);
    }

}
