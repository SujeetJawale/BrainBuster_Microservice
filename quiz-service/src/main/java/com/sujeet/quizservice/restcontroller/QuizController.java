package com.sujeet.quizservice.restcontroller;


import com.sujeet.quizservice.model.QuestionWrapper;
import com.sujeet.quizservice.model.QuizDto;
import com.sujeet.quizservice.model.Response;
import com.sujeet.quizservice.service.IQuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    private IQuizService quizService;

    @GetMapping("message")
    public ResponseEntity<String> getMessage() {
        return new ResponseEntity<String>("Hello", HttpStatus.OK);
    }

    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto dto) {
        String msg = quizService.createQuiz(dto.getCategoryName(), dto.getNumQ(), dto.getTitle());
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }

    @GetMapping("getquiz/{id}")
    public ResponseEntity<List<QuestionWrapper>> getAllQuestions(@PathVariable Integer id) {
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<String> createQuiz(@PathVariable Integer id, @RequestBody List<Response> resp) {
        String msg = quizService.calculateResult(id, resp);
        return new ResponseEntity<String>(msg, HttpStatus.OK);
    }
}
