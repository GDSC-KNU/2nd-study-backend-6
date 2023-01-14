package com.example.kcalog.service;

import com.example.kcalog.domain.Answer;
import com.example.kcalog.domain.Emotion;
import com.example.kcalog.domain.Member;
import com.example.kcalog.domain.Recommend;
import com.example.kcalog.repository.CommentRepository;
import com.example.kcalog.repository.RecommendRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@Transactional
@SpringBootTest
public class CommentServiceTest {
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    CommentService commentService;
    @Autowired
    RecommendRepository recommendRepository;


    @Test
    public void 댓글_등록() throws Throwable {
        //given
        Member member = new Member();
        Recommend recommend = new Recommend();
        Answer answer = new Answer();
        String content = "안녕하세요";
        Emotion emotion = Emotion.GOOD;
        recommendRepository.save(recommend.builder()
                .content(content)
                .build());
        commentRepository.save(answer.builder()
                .content(content)
                .emotion(emotion)
                .build());
        //when
        Long answerId = commentService.uploadComment(member.getName(), recommend.getId(), answer);
        //then
        Optional<Answer> getAnswer = commentRepository.findById(answerId);
        Assertions.assertThat(getAnswer.get().getContent()).isEqualTo(content);




    }


}