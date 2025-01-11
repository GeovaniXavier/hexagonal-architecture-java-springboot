package com.gx.hexagonal.adapters.out;

import com.gx.hexagonal.adapters.out.repository.CustomerRepository;
import com.gx.hexagonal.adapters.out.repository.mapper.CustomerEntityMapper;
import com.gx.hexagonal.application.core.domain.Customer;
import com.gx.hexagonal.application.ports.out.FindCustomerByIdOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FindCustomerByIdAdapter implements FindCustomerByIdOutputPort {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerEntityMapper customerEntityMapper;

    @Override
    public Optional<Customer> findById(String id) {
        var customerEntity = customerRepository.findById(id);
        return customerEntity.map(customerEntityMapper::toCustomer);
    }
}
