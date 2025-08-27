package com.example.FSWEB_s19_challenge.mapper;

import com.example.FSWEB_s19_challenge.dto.CommentPatchRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentRequestDto;
import com.example.FSWEB_s19_challenge.dto.CommentResponseDto;
import com.example.FSWEB_s19_challenge.entity.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentMapper {

    public Comment toEntity(CommentRequestDto commentRequestDto){
        Comment comment = new Comment();
        comment.setContent(commentRequestDto.content());
        return comment;
    }
    public CommentResponseDto toResponseDto(Comment comment){
        return new CommentResponseDto(comment.getContent());
    }

    public Comment updateEntity(Comment updateComment, CommentPatchRequestDto commentPatchRequestDto){
        if(commentPatchRequestDto != null){
            updateComment.setContent(commentPatchRequestDto.content());
        }
        return  updateComment;
    }
}
