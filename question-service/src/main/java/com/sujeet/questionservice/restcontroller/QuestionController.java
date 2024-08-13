package com.sujeet.questionservice.restcontroller;

import com.sujeet.questionservice.model.Question;
import com.sujeet.questionservice.model.QuestionWrapper;
import com.sujeet.questionservice.model.Response;
import com.sujeet.questionservice.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {

    @Autowired
    private IQuestionService service;

    @GetMapping("allquestions")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> list = service.getAllQuestions();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("addquestion")
    public ResponseEntity<String> addQuestion(@RequestBody Question question) {
        String msg = service.addQuestion(question);
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }

    @PostMapping("addallquestion")
    public ResponseEntity<String> addAllQuestion(@RequestBody Iterable<Question> questions) {
        String msg = service.addAllQuestion(questions);
        return new ResponseEntity<String>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Question>> getQuestionByCategory(@PathVariable String category) {
        List<Question> list = service.fetchQuestionsByCategory(category);
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PutMapping("updatequestion/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Integer id, @RequestBody Question question) {
        String msg = service.updateTheQuestion(id, question);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @PatchMapping("updateanswer/{id}/{answer}")
    public ResponseEntity<String> updateAnswerById(@PathVariable Integer id, @PathVariable String answer) {
        String msg = service.updateAnsById(id, answer);
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }


    @DeleteMapping("deletequestion/{id}")
    public ResponseEntity<String> deleteQuestion(@PathVariable int id) {
        String msg = service.deleteQuestionById(id);
        return new ResponseEntity<>(msg, HttpStatus.OK);
    }

    @GetMapping("generate")
    public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String category, @RequestParam Integer numQ) {
        List<Integer> list = service.getQuestionsForQuiz(category, numQ);
        return new ResponseEntity<List<Integer>>(list, HttpStatus.OK);
    }

    @PostMapping("getQuestions")
    public ResponseEntity<List<QuestionWrapper>> getQuestions(@RequestBody List<Integer> questionIds) {
        List<QuestionWrapper> list = service.getQuestionsFromIds(questionIds);
        return new ResponseEntity<List<QuestionWrapper>>(list, HttpStatus.CREATED);
    }

    @GetMapping("getscore")
    public ResponseEntity<Integer> getQuestionScore(@RequestBody List<Response> response) {
        Integer score = service.getScore(response);
        return new ResponseEntity<>(score, HttpStatus.OK);
    }
}
