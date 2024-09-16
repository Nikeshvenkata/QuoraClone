package org.clone.quora.repository;

import java.util.Optional;

import org.clone.quora.entity.Upvote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UpvoteRepository extends JpaRepository<Upvote, Integer> {
    Optional<Upvote> findByUserIdAndQuestionId(Integer userId, Integer questionId);
    Optional<Upvote> findByUserIdAndAnswerId(Integer userId, Integer answerId);
}