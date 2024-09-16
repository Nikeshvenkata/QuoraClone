package org.clone.quora.service;

import java.util.List;

import org.clone.quora.dto.QuestionDTO;
import org.clone.quora.entity.Question;
import org.clone.quora.entity.User;
import org.clone.quora.exception.ResourceNotFoundException;
import org.clone.quora.repository.QuestionRepository;
import org.clone.quora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private UserRepository userRepository;

    public Question createQuestion(QuestionDTO questionDTO, Integer userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Question question = new Question();
        question.setUser(user);
        question.setTitle(questionDTO.getTitle());
        question.setIsAnonymous(questionDTO.getIsAnonymous());

        return questionRepository.save(question);
    }

    public List<Question> searchQuestions(String keyword) {
        return questionRepository.findByTitleContaining(keyword);
    }
}