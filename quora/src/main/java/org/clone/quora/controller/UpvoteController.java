package org.clone.quora.controller;

import org.clone.quora.dto.UpvoteDTO;
import org.clone.quora.entity.Upvote;
import org.clone.quora.service.UpvoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/upvotes")
public class UpvoteController {

    @Autowired
    private UpvoteService upvoteService;

    @PostMapping("/upvote")
    public ResponseEntity<Upvote> upvote(@RequestBody UpvoteDTO upvoteDTO) {
        if (upvoteDTO.getQuestionId() != null) {
            Upvote upvote = upvoteService.upvoteQuestion(upvoteDTO.getUserId(), upvoteDTO.getQuestionId());
            return new ResponseEntity<>(upvote, HttpStatus.CREATED);
        } else if (upvoteDTO.getAnswerId() != null) {
            Upvote upvote = upvoteService.upvoteAnswer(upvoteDTO.getUserId(), upvoteDTO.getAnswerId());
            return new ResponseEntity<>(upvote, HttpStatus.CREATED);
        } else {
            throw new IllegalArgumentException("Either questionId or answerId must be provided");
        }
    }
}