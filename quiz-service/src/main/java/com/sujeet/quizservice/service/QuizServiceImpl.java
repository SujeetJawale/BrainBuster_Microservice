package com.sujeet.quizservice.service;


import com.sujeet.quizservice.dao.IQuizRepo;
import com.sujeet.quizservice.feign.QuizInterface;
import com.sujeet.quizservice.model.QuestionWrapper;
import com.sujeet.quizservice.model.Quiz;
import com.sujeet.quizservice.model.Response;
import org.antlr.v4.runtime.misc.IntegerList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements IQuizService {

    @Autowired
    private IQuizRepo quizRepo;

    @Autowired
    private QuizInterface quizI;

    @Override
    public String createQuiz(String category, Integer numQ, String quizTitle) {
        List<Integer> questions = quizI.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz = new Quiz();
        quiz.setTitle(quizTitle);
        quiz.setQuestionIds(questions);
        quizRepo.save(quiz);
        return "Successfully created Quiz";
    }

    @Override
    public ResponseEntity<List<QuestionWrapper>> getQuiz(Integer id) {
        Quiz quiz = quizRepo.findById(id).get();
        List<Integer> questionIds = quiz.getQuestionIds();
        ResponseEntity<List<QuestionWrapper>> questions = quizI.getQuestions(questionIds);
        return questions;
    }

    @Override
    public String calculateResult(Integer id, List<Response> resp) {
        ResponseEntity<Integer> right = quizI.getQuestionScore(resp);
        Integer rightAnswers = right.getBody();
        return "Correct Answers: " + rightAnswers;
    }
}
