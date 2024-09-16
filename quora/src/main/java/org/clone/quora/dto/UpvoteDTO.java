package org.clone.quora.dto;

public class UpvoteDTO {
    private Integer userId;
    private Integer questionId;  // Optional, depending on whether it's an upvote for a question
    private Integer answerId;    // Optional, depending on whether it's an upvote for an answer

    // Constructors
    public UpvoteDTO() {}

    public UpvoteDTO(Integer userId, Integer questionId, Integer answerId) {
        this.userId = userId;
        this.questionId = questionId;
        this.answerId = answerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getAnswerId() {
        return answerId;
    }

    public void setAnswerId(Integer answerId) {
        this.answerId = answerId;
    }
}