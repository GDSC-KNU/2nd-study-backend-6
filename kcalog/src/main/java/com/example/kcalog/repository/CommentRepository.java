package com.example.kcalog.repository;

import com.example.kcalog.domain.Answer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Answer, Long> {
}
