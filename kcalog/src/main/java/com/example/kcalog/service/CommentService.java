package com.example.kcalog.service;

import com.example.kcalog.domain.Answer;
import com.example.kcalog.domain.Member;
import com.example.kcalog.domain.Recommend;
import com.example.kcalog.repository.CommentRepository;
import com.example.kcalog.repository.MemberRepository;
import com.example.kcalog.repository.RecommendRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final RecommendRepository recommendRepository;

    // 답변 등록
    @Transactional
    public Long uploadComment(String name, Long id, Answer answer) throws Throwable {
         Member member = (Member) memberRepository.findByName(name);
         Recommend recommend = (Recommend) recommendRepository.findById(id).orElseThrow(() ->
                 new IllegalArgumentException("해당 게시물이 존재하지 않습니다"+id));
        commentRepository.save(answer);

        return answer.getId();
    }

    // 답변 삭제
    public void deleteComment(Long id){
        Answer answer = commentRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. id=" + id));
        commentRepository.delete(answer);
    }

    // 답변 수정
    public void updateComment(Long id, Answer answer){
        Answer answer1 = commentRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException("해당 댓글이 존재하지 않습니다. " + id));

        answer1.update(answer.getContent(), answer.getEmotion());

    }
}
