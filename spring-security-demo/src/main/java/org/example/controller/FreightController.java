package org.example.controller;

import jakarta.validation.Valid;
import org.example.payload.DeleteResponse;
import org.example.payload.FreightDto;
import org.example.service.FreightService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/customers")
public class FreightController {
    private final FreightService freightService;
    public FreightController(FreightService freightService) {
        this.freightService = freightService;
    }

    // spring boot rest api for creating the freight
    @PostMapping("/{id}/freights")
    public ResponseEntity<FreightDto> createFreight(
            @PathVariable("id") long customerId,
            @Valid @RequestBody FreightDto freightDto
    ){
        return new ResponseEntity<>(freightService.createFreight(customerId, freightDto),HttpStatus.CREATED);
    }

    // spring boot rest api for getting collection of freights using customer id
    @GetMapping("/{id}/freights")
    public ResponseEntity<List<FreightDto>> getFreightsByCustomerId(
            @PathVariable("id") long customerId
    ){
        return ResponseEntity.ok(freightService.getFreightByCustomerId(customerId));
    }

    // spring boot rest api for get freights using order id
    @GetMapping("/{id}/freights/{orderId}")
    public ResponseEntity<FreightDto> getFreightByOrderId(
            @PathVariable(value = "orderId") long orderId,
            @PathVariable(value = "id") long customerId
    ){
        return ResponseEntity.ok(freightService.getFreightById(customerId,orderId));
    }

    // spring boot rest api for updating the freights
    @PutMapping("/{id}/freights/{orderId}")
    public ResponseEntity<FreightDto> updateFreightByOrderId(
            @PathVariable(value = "id") long customerId,
            @PathVariable(value = "orderId") long orderId,
            @Valid @RequestBody FreightDto freightDto
    ){
        return ResponseEntity.ok(freightService.updateFreightById(customerId,orderId,freightDto));
    }

    // spring rest api for deleting hte freight
    @DeleteMapping("{id}/freights/{orderId}")
    public ResponseEntity<DeleteResponse> removeFreight(
            @PathVariable(value = "id") long customerId,
            @PathVariable(value = "orderId") long orderId)
    {
        freightService.removeFreight(customerId, orderId);
        DeleteResponse deleteResponse = new DeleteResponse("Customer removed successfully!");
        return ResponseEntity.ok(deleteResponse);
    }
}