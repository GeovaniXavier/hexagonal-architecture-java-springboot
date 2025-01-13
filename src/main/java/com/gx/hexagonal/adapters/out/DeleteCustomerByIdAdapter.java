package com.gx.hexagonal.adapters.out;

import com.gx.hexagonal.adapters.out.repository.CustomerRepository;
import com.gx.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DeleteCustomerByIdAdapter implements DeleteCustomerByIdOutputPort {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void deleteCustomerById(String id) {
        customerRepository.deleteById(id);
    }
}
