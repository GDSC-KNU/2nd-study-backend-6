package com.example.kcalog.controller;

import com.example.kcalog.domain.Answer;
import com.example.kcalog.domain.Member;
import com.example.kcalog.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class CommentApiController {
    private final CommentService commentService;

    /** create **/
    public ResponseEntity commentSave(Long id, Member member, Answer answer) throws Throwable {
        return ResponseEntity.ok(commentService.uploadComment(member.getName(), id, answer));
    }

    public ResponseEntity update(Long id, Answer answer){
        commentService.updateComment(id, answer);
        return ResponseEntity.ok(id);
    }

    public ResponseEntity delete(Long id){
        commentService.deleteComment(id);
        return ResponseEntity.ok(id);
    }

}
