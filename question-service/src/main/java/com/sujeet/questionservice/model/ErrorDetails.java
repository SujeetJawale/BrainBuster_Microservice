package com.sujeet.questionservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String status;

    private String message;

    private LocalDateTime timestamp;
}
