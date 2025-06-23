package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Schema(
        name = "Response",
        description = "Schema to hold successfull response information"
)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDto {

    @Schema(description = "Status code in the response")
    private String statusCode;

    @Schema(description = "Status code in the response", example = "Request processed successfully")
    private String statusMsg;

}
