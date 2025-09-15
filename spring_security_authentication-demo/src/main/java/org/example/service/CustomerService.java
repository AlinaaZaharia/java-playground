package org.example.service;

import org.example.payload.CustomerDto;
import org.example.payload.CustomerResponse;

public interface CustomerService {
    String createCustomer(CustomerDto customerDto);
    CustomerDto updateCustomer(long id,CustomerDto customerDto);
    CustomerResponse getCustomers(int pageNo, int pageSize, String sortBy, String sortDir);
    CustomerDto getCustomerById(long id);
    void removeCustomer(long id);
}