package org.task4.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task4.DTO.blog.BlogRequestDTO;
import org.task4.DTO.blog.BlogRequestRemoveDTO;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.service.blog.BlogAddService;
import org.task4.service.blog.BlogFindService;
import org.task4.service.blog.BlogUpdateService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@AllArgsConstructor
public class BlogController {
    private final BlogUpdateService blogUpdateService;
    BlogAddService blogAddService;
    BlogFindService blogFindService;

    @GetMapping({"","/"})
    public ResponseEntity<List<BlogResponseDTO>> getAll(){
        return new ResponseEntity<>(blogFindService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BlogResponseDTO> addBlog(@RequestBody @Valid BlogRequestDTO blog){
        return new ResponseEntity<>(blogAddService.addBlog(blog), HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<Boolean> updateBlog(@RequestBody @Valid BlogRequestDTO blogDTO){
        blogUpdateService.update(blogDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/remove")
    public ResponseEntity<Boolean> removeBlog(@RequestBody @Valid BlogRequestRemoveDTO blogDTO){
        blogUpdateService.remove(blogDTO);
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
