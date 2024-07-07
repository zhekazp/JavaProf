package org.task4.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task4.DTO.blogComment.BlCommentRequestDTO;
import org.task4.service.blogComment.BlogCommentAddService;

@RestController
@RequestMapping("/blogcomment")
@AllArgsConstructor
public class BlogCommentController {
    private final BlogCommentAddService blogCommentAddService;




    @PostMapping("/add")
    public ResponseEntity<Boolean> add(@RequestBody @Valid BlCommentRequestDTO requestDTO) {
        blogCommentAddService.addCommentBlog(requestDTO);
        return ResponseEntity.ok(true);
    }
}
