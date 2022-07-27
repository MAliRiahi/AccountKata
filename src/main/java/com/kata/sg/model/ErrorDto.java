package com.kata.sg.model;

import com.kata.sg.enums.ErrorCodes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ErrorDto {
    private Integer httpCode;
    private ErrorCodes errorCode;
    private String message;
    private List<String> errors= new ArrayList<>();
}
