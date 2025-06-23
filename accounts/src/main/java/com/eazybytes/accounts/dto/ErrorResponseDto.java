package com.eazybytes.accounts.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


@Schema(
        name = "ErrorResponse",
        example = "Schema to hold error response information"
)
@Data
@AllArgsConstructor
public class ErrorResponseDto {

    @Schema(example = "API path invoked by client")
    private String apiPath;
    @Schema(example = "Error Code representing the error happened")
    private HttpStatus errorCode;
    @Schema(example = "Error message representing the error happened")
    private String errorMessage;

    @Schema(example = "Time representing the error happened")
    private LocalDateTime errorTime;

}
