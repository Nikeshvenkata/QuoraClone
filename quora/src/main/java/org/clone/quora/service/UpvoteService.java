package org.clone.quora.service;

import org.clone.quora.entity.*;
import org.clone.quora.exception.ResourceNotFoundException;
import org.clone.quora.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpvoteService {
    @Autowired
    private UpvoteRepository upvoteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    public Upvote upvoteQuestion(Integer userId, Integer questionId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        Question question = questionRepository.findById(questionId)
            .orElseThrow(() -> new ResourceNotFoundException("Question not found"));

        if (upvoteRepository.findByUserIdAndQuestionId(userId, questionId).isPresent()) {
            throw new IllegalArgumentException("You have already upvoted this question");
        }

        Upvote upvote = new Upvote();
        upvote.setUser(user);
        upvote.setQuestion(question);
        
        return upvoteRepository.save(upvote);
    }

    public Upvote upvoteAnswer(Integer userId, Integer answerId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        
        Answer answer = answerRepository.findById(answerId)
            .orElseThrow(() -> new ResourceNotFoundException("Answer not found"));

        if (upvoteRepository.findByUserIdAndAnswerId(userId, answerId).isPresent()) {
            throw new IllegalArgumentException("You have already upvoted this answer");
        }

        Upvote upvote = new Upvote();
        upvote.setUser(user);
        upvote.setAnswer(answer);

        return upvoteRepository.save(upvote);
    }
}