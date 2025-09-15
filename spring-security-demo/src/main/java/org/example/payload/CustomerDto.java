package org.example.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private long id;
    @NotEmpty
    private String customerName;

    @NotEmpty
    @Email
    private String customerEmail;
    private Set<FreightDto> freights;
}