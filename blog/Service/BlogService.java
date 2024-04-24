package com.example.blog.Service;


import com.example.blog.Model.Blog;
import com.example.blog.Model.User;
import com.example.blog.Repository.AuthRepository;
import com.example.blog.Repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogService {


    private final BlogRepository blogRepository;
    private final AuthRepository authRepository;


    public void addBlog(Integer userid , Blog blog) {

        User user = authRepository.findUserById(userid);

        blog.setUser(user);
        blogRepository.save(blog);

    }


    public List<Blog> getMyBlogs(Integer id){

        User user = authRepository.findUserById(id);

        return blogRepository.findAllByUser(user);
    }



    public void deleteBlog(Integer userid , Integer blogId ){
        User user = authRepository.findUserById(userid);
        Blog blog = blogRepository.findBlogById(blogId);

        if (blog.getUser().equals(user) ) {
            blogRepository.delete(blog);
        }
    }



    public void updateBlog(Integer userid , Integer blogId , Blog blog ){
        User user = authRepository.findUserById(userid);
        Blog blog1 = blogRepository.findBlogById(blogId);

        if (blog.getUser().equals(user)  ) {
            blog1.setTitle(blog.getTitle());
            blog1.setBody(blog.getBody());
            blogRepository.save(blog1);
        }
    }


    public Blog getBlogByTitle(Integer userid , String title ){
        User user = authRepository.findUserById(userid);
        Blog blog = blogRepository.findBlogByTitle(title);

        if (blog.getUser().equals(user)) {
            return blog;
        }
        return null;
    }
}
