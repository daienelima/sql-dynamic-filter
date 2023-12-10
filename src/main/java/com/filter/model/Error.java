package com.filter.model;

import com.fasterxml.jackson.annotation.JsonClassDescription;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonClassDescription
public class Error {
    private String error;
    private String details;
}
