package com.sujeet.questionservice.exception;


public class QuestionNotFoundError extends RuntimeException {
    public QuestionNotFoundError(String message) {
        super(message);
    }
}
