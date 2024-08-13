package com.sujeet.questionservice.dao;

import com.sujeet.questionservice.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IQuestionRepo extends JpaRepository<Question, Integer> {
    public List<Question> findByCategory(String category);

    @Query(value = "Select q.id FROM question q WHERE q.category=:category ORDER BY RAND() LIMIT :numQ", nativeQuery = true)
    public List<Integer> findRandomQuestionsByCategory(String category, Integer numQ);
}
