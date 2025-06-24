package com.eazybytes.cards.exception;

import com.eazybytes.cards.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ){
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach(error -> {
            String fieldName = error.getObjectName();
            String errorMessage = error.getDefaultMessage();
            validationErrors.put(fieldName, errorMessage);
        });

        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setApiPath(webRequest.getDescription(false));
        errorResponseDto.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR);
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(java.time.LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotFoundException(ResourceNotFoundException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setApiPath(webRequest.getDescription(false));
        errorResponseDto.setErrorCode(HttpStatus.NOT_FOUND);
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(java.time.LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(CardAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCardAlreadyExistsException(CardAlreadyExistsException exception, WebRequest webRequest) {
        ErrorResponseDto errorResponseDto = new ErrorResponseDto();
        errorResponseDto.setApiPath(webRequest.getDescription(false));
        errorResponseDto.setErrorCode(HttpStatus.CONFLICT);
        errorResponseDto.setErrorMessage(exception.getMessage());
        errorResponseDto.setErrorTime(LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);
    }
}
