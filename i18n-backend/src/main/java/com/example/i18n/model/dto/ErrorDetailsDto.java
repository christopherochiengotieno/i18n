package com.example.i18n.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorDetailsDto {
    private String message;
}
