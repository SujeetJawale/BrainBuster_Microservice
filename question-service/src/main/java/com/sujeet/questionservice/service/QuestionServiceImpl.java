package com.sujeet.questionservice.service;


import com.sujeet.questionservice.dao.IQuestionRepo;
import com.sujeet.questionservice.exception.QuestionNotFoundError;
import com.sujeet.questionservice.model.Question;
import com.sujeet.questionservice.model.QuestionWrapper;
import com.sujeet.questionservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionServiceImpl implements IQuestionService{

    @Autowired
    private IQuestionRepo repo;

    public List<Question> getAllQuestions() {
        return repo.findAll();
    }

    @Override
    public String addQuestion(Question question) {
        repo.save(question);
        return "Question added successfully";
    }

    @Override
    public String addAllQuestion(Iterable<Question> questions) {
        repo.saveAll(questions);
        return "All Questions added successfully";
    }

    @Override
    public List<Question> fetchQuestionsByCategory(String category) {
        return repo.findByCategory(category);
    }

    @Override
    public String deleteQuestionById(int id) {
        Question question = repo.findById(id).orElseThrow(() -> new QuestionNotFoundError("Question not Found"));
        repo.delete(question);
        return "Question deleted successfully with id: " + id;
    }

    @Override
    public String updateTheQuestion(Integer id, Question question){
        Question dbQuestion = repo.findById(id).orElseThrow(() -> new QuestionNotFoundError("Question not Found"));
        dbQuestion.setQuestion(question.getQuestion());
        dbQuestion.setDifficulty(question.getDifficulty());
        dbQuestion.setOption1(question.getOption1());
        dbQuestion.setOption2(question.getOption2());
        dbQuestion.setOption3(question.getOption3());
        dbQuestion.setOption4(question.getOption4());
        dbQuestion.setCategory(question.getCategory());
        dbQuestion.setRightAnswer(question.getRightAnswer());
        repo.save(dbQuestion);
        return "Question updated successfully with id: " + id;
    }

    @Override
    public String updateAnsById(Integer id, String answer) {
        Question dbQuestion = repo.findById(id).orElseThrow(() -> new QuestionNotFoundError("Question not Found"));
        dbQuestion.setRightAnswer(answer);
        repo.save(dbQuestion);
        return "Answer for question updated successfully with id: " + id;
    }

    @Override
    public List<Integer> getQuestionsForQuiz(String category, Integer numQ) {
        return repo.findRandomQuestionsByCategory(category, numQ);
    }

    @Override
    public List<QuestionWrapper> getQuestionsFromIds(List<Integer> questionIds) {
        List<QuestionWrapper> wrappers = new ArrayList<>();
        List<Question> questions = new ArrayList();
        for(Integer id: questionIds) {
            questions.add(repo.findById(id).orElseThrow(() -> new QuestionNotFoundError("Question not Found")));
        }

        for(Question question: questions) {
            QuestionWrapper wrapper = new QuestionWrapper();
            wrapper.setId(question.getId());
            wrapper.setQuestion(question.getQuestion());
            wrapper.setOption1(question.getOption1());
            wrapper.setOption2(question.getOption2());
            wrapper.setOption3(question.getOption3());
            wrapper.setOption4(question.getOption4());
            wrappers.add(wrapper);
        }
        return wrappers;
    }

    @Override
    public Integer getScore(List<Response> response) {
        int right = 0;
        for (Response resp : response) {
            Question ques = repo.findById(resp.getId()).get();
            if(resp.getResponse().equals(ques.getRightAnswer()))
                right++;
        }
        return right;
    }


}

