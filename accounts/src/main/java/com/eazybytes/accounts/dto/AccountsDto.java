package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        name = "Accounts",
        description = "Schema to hold Account information"
)
public class AccountsDto {

    @Schema(description = "Account number of bank account")
    @NotEmpty(message = "Account number cannot not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account number must be 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Account type of bank account",
            example = "SAVINGS, FIXED DEPOSIT"
    )
    @NotEmpty(message = "Account type cannot not be empty")
    private String accountType;


    @Schema(description = "branch address of Bank")
    @NotEmpty(message = "Branch address cannot not be empty")
    private String branchAddress;
}
