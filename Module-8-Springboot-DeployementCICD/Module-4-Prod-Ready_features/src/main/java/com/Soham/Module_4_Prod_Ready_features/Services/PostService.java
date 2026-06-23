package com.Soham.Module_4_Prod_Ready_features.Services;


import com.Soham.Module_4_Prod_Ready_features.DTOs.PostDTO;
import com.Soham.Module_4_Prod_Ready_features.Entities.PostEntity;
import com.Soham.Module_4_Prod_Ready_features.Exceptions.ResourceNotFoundException;
import com.Soham.Module_4_Prod_Ready_features.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService{

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
        PostEntity postEntity = postRepository
                .findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found with id "+postId));
        return modelMapper.map(postEntity, PostDTO.class);
    }
}
