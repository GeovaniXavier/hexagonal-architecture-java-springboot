package com.gx.hexagonal.adapters.out.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "address")
public class CustomerEntity {

    @Id
    private String id;

    private String nome;

    private AddressEntity address;

    private String cpf;

    private Boolean isValidCpf;


}
