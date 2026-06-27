package com.Soham.Module_5_Spring_Security_Fundamentals.Utils;

import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.PostDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import com.Soham.Module_5_Spring_Security_Fundamentals.Services.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostSecurity {

    private  final PostServiceImpl postService;

    public boolean isOwnerOfPost(Long postId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostDTO post = postService.getPostById(postId);
        return post.getAuthor().getId().equals(user.getId());
    }

}