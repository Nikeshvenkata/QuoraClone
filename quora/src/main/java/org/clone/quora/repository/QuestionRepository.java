package org.clone.quora.repository;

import java.util.List;

import org.clone.quora.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByTitleContaining(String title);
}