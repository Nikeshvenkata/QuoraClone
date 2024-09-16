package org.clone.quora.service;

import java.util.List;

import org.clone.quora.dto.AnswerDTO;
import org.clone.quora.entity.Answer;
import org.clone.quora.entity.Question;
import org.clone.quora.entity.User;
import org.clone.quora.exception.ResourceNotFoundException;
import org.clone.quora.repository.AnswerRepository;
import org.clone.quora.repository.QuestionRepository;
import org.clone.quora.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {
    @Autowired
    private AnswerRepository answerRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    public Answer addAnswer(AnswerDTO answerDTO, Integer userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Question question = questionRepository.findById(answerDTO.getQuestionId())
            .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        Answer answer = new Answer();
        answer.setUser(user);
        answer.setQuestion(question);
        answer.setAnswerText(answerDTO.getAnswerText());
        answer.setIsAnonymous(answerDTO.getIsAnonymous());

        return answerRepository.save(answer);
    }

    public List<Answer> getAnswersByQuestion(Integer questionId) {
        return answerRepository.findByQuestionId(questionId);
    }
}