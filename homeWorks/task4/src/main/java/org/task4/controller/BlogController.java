package org.task4.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task4.DTO.blog.BlogDTO;
import org.task4.DTO.blog.BlogResponseDTO;
import org.task4.service.blog.BlogAddService;
import org.task4.service.blog.BlogFindService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@AllArgsConstructor
public class BlogController {
    BlogAddService blogAddService;
    BlogFindService blogFindService;

    @GetMapping({"","/"})
    public ResponseEntity<List<BlogResponseDTO>> getAll(){
        return new ResponseEntity<>(blogFindService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<BlogResponseDTO> addBlog(@RequestBody BlogDTO blog){
        Optional<BlogResponseDTO> newBlog = blogAddService.addBlog(blog);
        if (newBlog.isEmpty()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(newBlog.get(), HttpStatus.CREATED);
    }
}
