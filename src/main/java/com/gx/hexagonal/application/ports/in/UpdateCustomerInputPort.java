package com.gx.hexagonal.application.ports.in;

import com.gx.hexagonal.application.core.domain.Customer;

public interface UpdateCustomerInputPort {

    void update(Customer customer, String zipCode);

}
