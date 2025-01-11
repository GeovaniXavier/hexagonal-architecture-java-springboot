package com.gx.hexagonal.application.ports.in;

import com.gx.hexagonal.application.core.domain.Customer;

public interface FindCustomerByIdInputPort {

    Customer findCustomerById(String id);

}
