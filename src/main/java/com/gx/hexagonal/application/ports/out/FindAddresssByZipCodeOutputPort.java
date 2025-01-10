package com.gx.hexagonal.application.ports.out;

import com.gx.hexagonal.application.core.domain.Address;

public interface FindAddresssByZipCodeOutputPort {

    Address find(String zipCode);

}
