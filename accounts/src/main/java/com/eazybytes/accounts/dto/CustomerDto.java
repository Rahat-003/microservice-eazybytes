package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(
        name = "Customer",
        description = "Schema to hold Customer and Account information"
)
public class CustomerDto {

    @Schema(
            description = "name of the customer",
            example = "Madan Reddy"
    )
    @NotEmpty(message = "Name cannot not be empty")
    @Size(min = 5, max = 30, message = "The length of the customer name must be between 5 and 30")
    private String name;


    @Schema(
            description = "email of the customer",
            example = "tutor@eazybytes.com"
    )
    @NotEmpty(message = "Email cannot not be empty")
    @Email(message = "Email address is not valid")
    private String email;


    @Schema(
            description = "mobile number of the customer",
            example = "4354437687"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile number must be 10 digits")
    private String mobileNumber;


    @Schema(description = "Account details of the customer")
    private AccountsDto accountsDto;
}
