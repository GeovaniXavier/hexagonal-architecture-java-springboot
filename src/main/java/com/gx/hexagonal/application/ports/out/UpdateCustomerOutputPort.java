package com.gx.hexagonal.application.ports.out;

import com.gx.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}
