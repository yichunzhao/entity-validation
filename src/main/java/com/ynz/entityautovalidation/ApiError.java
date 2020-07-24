package com.ynz.entityautovalidation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;


@Builder
@AllArgsConstructor
@Getter
@Setter
public class ApiError {
    private HttpStatus status;
    private String message;
    private List<String> errors;
}
