package com.sujeet.quizservice.dao;

import com.sujeet.quizservice.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuizRepo extends JpaRepository<Quiz, Integer> {

}
