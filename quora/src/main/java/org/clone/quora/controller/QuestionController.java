package org.clone.quora.controller;

import java.util.List;

import org.clone.quora.dto.QuestionDTO;
import org.clone.quora.entity.Question;
import org.clone.quora.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Question> addQuestion(@RequestBody QuestionDTO questionDTO, @PathVariable Integer userId) {
        Question question = questionService.createQuestion(questionDTO, userId);
        return new ResponseEntity<>(question, HttpStatus.CREATED);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Question>> searchQuestions(@PathVariable String keyword) {
        List<Question> questions = questionService.searchQuestions(keyword);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }
}