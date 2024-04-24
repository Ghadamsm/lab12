package com.example.blog.Controller;


import com.example.blog.Model.Blog;
import com.example.blog.Model.User;
import com.example.blog.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor
public class BlogController {


    private final BlogService blogService;


    @GetMapping("/get")
    public ResponseEntity getMyBlog(@AuthenticationPrincipal User user){

        return ResponseEntity.status(200).body(blogService.getMyBlogs(user.getId()));
    }


    @PostMapping("/add")
    public ResponseEntity addBlog(@AuthenticationPrincipal User user,@RequestBody @Valid Blog blog){
        blogService.addBlog(user.getId(), blog);
        return ResponseEntity.status(200).body("blog added");
    }



    @DeleteMapping("/delete/{blogId}")
    public ResponseEntity deleteBlog(@AuthenticationPrincipal User user,@PathVariable Integer blogId){
        blogService.deleteBlog(user.getId(), blogId);
        return ResponseEntity.status(200).body("blog deleted");
    }


    @PutMapping("/update/{blogId}")
    public ResponseEntity updateBlog(@AuthenticationPrincipal User user, @PathVariable Integer blogId , @RequestBody @Valid Blog blog){
        blogService.updateBlog(user.getId(), blogId, blog);
        return ResponseEntity.status(200).body("blog updated");
    }


    @GetMapping("/get_title/{title}")
    public ResponseEntity getBlogByTitle(@AuthenticationPrincipal User user, String title){
        return ResponseEntity.status(200).body(blogService.getBlogByTitle(user.getId(), title));
    }

}
