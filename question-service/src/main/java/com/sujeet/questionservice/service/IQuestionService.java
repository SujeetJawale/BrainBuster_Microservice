package com.sujeet.questionservice.service;

import com.sujeet.questionservice.exception.QuestionNotFoundError;
import com.sujeet.questionservice.model.Question;
import com.sujeet.questionservice.model.QuestionWrapper;
import com.sujeet.questionservice.model.Response;

import java.util.List;

public interface IQuestionService {
    public List<Question> getAllQuestions();
    public String addQuestion(Question question);
    public String addAllQuestion(Iterable<Question> questions);
    public List<Question> fetchQuestionsByCategory(String category);
    public String deleteQuestionById(int id);
    public String updateTheQuestion(Integer id, Question question) throws QuestionNotFoundError;
    public String updateAnsById(Integer id, String answer);
    public List<Integer> getQuestionsForQuiz(String category, Integer numQ);
    public List<QuestionWrapper> getQuestionsFromIds(List<Integer> questionIds);
    public Integer getScore(List<Response> response);
}
