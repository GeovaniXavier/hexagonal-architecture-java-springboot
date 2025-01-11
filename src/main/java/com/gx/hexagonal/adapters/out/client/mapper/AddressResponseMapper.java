package com.gx.hexagonal.adapters.out.client.mapper;

import com.gx.hexagonal.adapters.out.client.response.AddressResponse;
import com.gx.hexagonal.application.core.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {


    Address toAddress(AddressResponse addressResponse);

}
