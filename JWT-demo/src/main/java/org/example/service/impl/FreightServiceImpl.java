package org.example.service.impl;

import org.example.entity.Customer;
import org.example.entity.Freight;
import org.example.exception.FreightAPIException;
import org.example.exception.ResourceNotFoundException;
import org.example.payload.FreightDto;
import org.example.repository.CustomerRepository;
import org.example.repository.FreightRepository;
import org.example.service.FreightService;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreightServiceImpl implements FreightService {
    private final FreightRepository freightRepository;
    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;

    public FreightServiceImpl(FreightRepository freightRepository, CustomerRepository customerRepository, ModelMapper modelMapper) {
        this.freightRepository = freightRepository;
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
    }

    // map to dto
    private FreightDto mapToDto(Freight freight){
        return modelMapper.map(freight,FreightDto.class);
    }

    // map to entity
    private Freight mapToEntity(FreightDto freightDto){
        return modelMapper.map(freightDto,Freight.class);
    }

    @Override
    public FreightDto createFreight(long customerId, FreightDto freightDto) {
        Freight freight = mapToEntity(freightDto);
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "id", customerId));
        freight.setCustomer(customer);

        Freight created = freightRepository.save(freight);
        return mapToDto(created);
    }

    @Override
    public List<FreightDto> getFreightByCustomerId(long customerId) {
        if(!freightRepository.existsByCustomerId(customerId)){
            throw new FreightAPIException(HttpStatus.BAD_REQUEST,
                    "Customer Id: "+customerId+" is invalid please try again!");
        }
        List<Freight> customers = freightRepository.findByCustomerId(customerId);
        return customers.stream().map(c->mapToDto(c)).collect(Collectors.toList());
    }

    @Override
    public FreightDto getFreightById(long customerId, long orderId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "id", customerId));
        Freight freight = freightRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Freight", "orderId", orderId));
        if(freight.getCustomer().getId()!=customer.getId()){
            throw new FreightAPIException(HttpStatus.BAD_REQUEST,"Freight doesn't belong to the customer");
        }
        return mapToDto(freight);
    }

    @Override
    public FreightDto updateFreightById(long customerId, long orderId, FreightDto freightDto) {
        Customer customer =
                customerRepository.findById(customerId).orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "id",
                                customerId));
        Freight freight = freightRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Freight", "orderId", orderId));
        if(freight.getCustomer().getId()!=customer.getId()){
            throw new FreightAPIException(HttpStatus.BAD_REQUEST,"Freight doesn't belong to the customer");
        }

        freight.setOrigin(freightDto.getOrigin());
        freight.setDestination(freightDto.getDestination());
        Freight updated = freightRepository.save(freight);
        return mapToDto(updated);
    }

    @Override
    public void removeFreight(long customerId, long orderId) {
        Customer customer = customerRepository.findById(customerId).orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "id", customerId));
        Freight freight = freightRepository.findById(orderId).orElseThrow(
                () -> new ResourceNotFoundException("Freight", "orderId", orderId));
        if(freight.getCustomer().getId()!=customer.getId()){
            throw new FreightAPIException(HttpStatus.BAD_REQUEST,"Freight doesn't belong to the customer");
        }
        freightRepository.delete(freight);
    }
}