package com.example.bloog.Controller;

import com.example.bloog.ADO.ApiDto;
import com.example.bloog.BlogRepository.BlogRepository;
import com.example.bloog.Model.Blogs;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/blog")
@CrossOrigin(origins = "*")
public class BlogController {
    private final BlogRepository blogRepository;

    @GetMapping
    public ResponseEntity getBlogs(){
        return ResponseEntity.status(200).body(blogRepository.findAll());
    }

    @PostMapping
    public ResponseEntity addBlog(@RequestBody Blogs blogs){
        blogRepository.save(blogs);
        return ResponseEntity.status(201).body(new ApiDto("New blog added !",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity getBlogById(@PathVariable Integer id){
        Blogs blogs=blogRepository.findById(id).get();
        return ResponseEntity.status(200).body(blogs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBlog(@PathVariable Integer id){
        Optional<Blogs> blog = blogRepository.findById(id);
        if(blog.isEmpty()){
            return ResponseEntity.status(400).body("Invalid id");
        }
        blogRepository.delete(blog.get());
        return ResponseEntity.status(200).body(new ApiDto("Blog deleted",200));
    }

}
