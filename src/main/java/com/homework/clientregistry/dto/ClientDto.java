package com.homework.clientregistry.dto;

import java.util.Date;
import java.util.List;

public record ClientDto(Long id, String name, String mothersName, Date birthDate, String birthPlace,
                        String socialSecurityNumber, String emailAddress,
                        List<AddressDto> addresses, List<PhoneNumberDto> phoneNumbers) { }
