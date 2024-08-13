package com.sujeet.questionservice.advice;

import com.sujeet.questionservice.exception.QuestionNotFoundError;
import com.sujeet.questionservice.model.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class QuestionErrorController {

    @ExceptionHandler(QuestionNotFoundError.class)
    public ResponseEntity<ErrorDetails> handleExceptionForQuestionNotFound(QuestionNotFoundError error) {
        ErrorDetails errorDetails = new ErrorDetails("404 Not Found", error.getMessage(), LocalDateTime.now());
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleExceptionTourist(Exception e) {
        ErrorDetails error = new ErrorDetails("404 Not Found", e.getMessage(), LocalDateTime.now());
        return new ResponseEntity<ErrorDetails>(error, HttpStatus.BAD_REQUEST);
    }
}
