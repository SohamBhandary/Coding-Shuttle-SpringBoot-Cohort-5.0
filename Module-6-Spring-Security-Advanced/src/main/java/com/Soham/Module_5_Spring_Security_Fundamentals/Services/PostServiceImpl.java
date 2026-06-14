package com.Soham.Module_5_Spring_Security_Fundamentals.Services;


import com.Soham.Module_5_Spring_Security_Fundamentals.DTOs.PostDTO;
import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.PostEntity;
import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.User;
import com.Soham.Module_5_Spring_Security_Fundamentals.Exceptions.ResourceNotFoundException;
import com.Soham.Module_5_Spring_Security_Fundamentals.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PostServiceImpl {

    private final PostRepository postRepository;
    private final ModelMapper modelMapper;


    public List<PostDTO> getAllPosts() {
        return postRepository
                .findAll()
                .stream()
                .map(postEntity -> modelMapper.map(postEntity, PostDTO.class))
                .collect(Collectors.toList());
    }


    public PostDTO createNewPost(PostDTO inputPost) {
        PostEntity postEntity = modelMapper.map(inputPost, PostEntity.class);
        return modelMapper.map(postRepository.save(postEntity), PostDTO.class);
    }


    public PostDTO getPostById(Long postId) {
//        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id " + postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
