package com.example.FSWEB_s19_challenge.controller;

import com.example.FSWEB_s19_challenge.dto.CommentPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentResponseDto;
import com.example.FSWEB_s19_challenge.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @PostMapping()
    public CommentResponseDto create(@RequestBody CommentRequestDto commentRequestDto){
        return commentService.create(commentRequestDto);
    }

    @PatchMapping("/{id}")
    public CommentResponseDto update(@PathVariable Long id,
                                     @RequestBody CommentPatchRequestDto commentPatchRequestDto) {
        return commentService.update(id, commentPatchRequestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }


}
