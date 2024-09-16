package org.clone.quora.controller;

import java.util.List;

import org.clone.quora.dto.AnswerDTO;
import org.clone.quora.entity.Answer;
import org.clone.quora.service.AnswerService;
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
@RequestMapping("/api/answers")
public class AnswerController {
    @Autowired
    private AnswerService answerService;

    @PostMapping("/add/{userId}")
    public ResponseEntity<Answer> addAnswer(@RequestBody AnswerDTO answerDTO, @PathVariable Integer userId) {
        Answer answer = answerService.addAnswer(answerDTO, userId);
        return new ResponseEntity<>(answer, HttpStatus.CREATED);
    }

    @GetMapping("/question/{id}")
    public ResponseEntity<List<Answer>> getAnswers(@PathVariable Integer id) {
        List<Answer> answers = answerService.getAnswersByQuestion(id);
        return new ResponseEntity<>(answers, HttpStatus.OK);
    }
}