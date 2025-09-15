package org.example.controller;

import jakarta.validation.Valid;
import org.example.payload.CustomerDto;
import org.example.payload.CustomerResponse;
import org.example.payload.DeleteResponse;
import org.example.service.CustomerService;
import org.example.utils.AppsConstant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/customers")
public class CustomerController {
    private final CustomerService customerService;
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> createCustomer(
            @Valid @RequestBody CustomerDto customerDto
    ){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerResponse> getCustomers(
            @RequestParam(value = "pageNo",defaultValue =
                    AppsConstant.DEFAULT_PAGE_NO,required = false) int pageNo,
            @RequestParam(value = "pageSize",defaultValue =
                    AppsConstant.DEFAULT_PAGE_SIZE,required = false) int pageSize,
            @RequestParam(value = "sortBy",defaultValue =
                    AppsConstant.DEFAULT_SORT_BY,required = false) String sortBy,
            @RequestParam(value = "sortDir",defaultValue =
                    AppsConstant.DEFAULT_SORT_DIR,required = false) String sortDir
    ){
        return
                ResponseEntity.ok(customerService.getCustomers(pageNo,pageSize,sortBy,sortDir)
                );
    }

    @PutMapping("{id}")
    public ResponseEntity<CustomerDto> updateCustomerById(
            @PathVariable(value = "id") long id,
            @Valid @RequestBody CustomerDto customerDto
    ){
        return ResponseEntity.ok(customerService.updateCustomer(id,customerDto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDto> getCustomerById(
            @PathVariable(value = "id") long id
    ){
        return ResponseEntity.ok(customerService.getCustomerById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DeleteResponse> removeCustomer(
            @PathVariable(value = "id") long id
    ){
        customerService.removeCustomer(id);
        DeleteResponse deleteResponse = new DeleteResponse("Customer deleted successfully!");
        return ResponseEntity.ok(deleteResponse);
    }
}