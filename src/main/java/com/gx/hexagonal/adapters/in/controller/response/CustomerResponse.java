package com.gx.hexagonal.adapters.in.controller.response;

import com.gx.hexagonal.application.core.domain.Address;
import lombok.Data;

@Data
public class CustomerResponse {

    private String nome;

    private Address address;

    private String cpf;

    private Boolean isValidCpf;
}
