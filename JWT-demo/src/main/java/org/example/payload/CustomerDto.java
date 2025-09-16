package org.example.payload;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
    private String customerName;
    private String customerEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String customerPassword;
}