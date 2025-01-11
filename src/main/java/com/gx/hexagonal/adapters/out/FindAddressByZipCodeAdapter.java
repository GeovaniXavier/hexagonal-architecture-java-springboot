package com.gx.hexagonal.adapters.out;

import com.gx.hexagonal.adapters.out.client.FindAddressByZipCodeClient;
import com.gx.hexagonal.adapters.out.client.mapper.AddressResponseMapper;
import com.gx.hexagonal.application.core.domain.Address;
import com.gx.hexagonal.application.ports.out.FindAddresssByZipCodeOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FindAddressByZipCodeAdapter implements FindAddresssByZipCodeOutputPort {

    @Autowired
    private FindAddressByZipCodeClient findAddressByZipCodeClient;

    @Autowired
    private AddressResponseMapper addressResponseMapper;

    @Override
    public Address find(String zipCode) {
        var addressResponse = findAddressByZipCodeClient.find(zipCode);
        return addressResponseMapper.toAddress(addressResponse);
    }
}
