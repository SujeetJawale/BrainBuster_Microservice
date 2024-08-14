package com.sujeet.quizservice.service;

import com.sujeet.quizservice.model.QuestionWrapper;
import com.sujeet.quizservice.model.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface IQuizService {
    public String createQuiz(String category, Integer numQ, String quizTitle);
    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id);
    public String calculateResult(Integer id, List<Response> resp);
}
