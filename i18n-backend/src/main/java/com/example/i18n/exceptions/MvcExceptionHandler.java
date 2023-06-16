package com.example.i18n.exceptions;

import com.example.i18n.config.LocaleConfig;
import com.example.i18n.model.dto.ErrorDetailsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@RequiredArgsConstructor
public class MvcExceptionHandler {

    private final MessageSource messageSource;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetailsDto> exception(Exception e) {
        String message = messageSource.getMessage(e.getMessage(),null, LocaleConfig.GLOBAL_LOCALE);
        ErrorDetailsDto errorDetails =  ErrorDetailsDto.builder().message(message).build();
        return ResponseEntity.badRequest().body(errorDetails);
    }
}
