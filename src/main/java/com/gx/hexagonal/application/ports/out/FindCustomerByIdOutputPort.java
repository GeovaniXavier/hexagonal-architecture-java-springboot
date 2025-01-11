package com.gx.hexagonal.application.ports.out;

import com.gx.hexagonal.application.core.domain.Customer;

import java.util.Optional;

public interface FindCustomerByIdOutputPort {

    Optional<Customer> findById(String id);

}
