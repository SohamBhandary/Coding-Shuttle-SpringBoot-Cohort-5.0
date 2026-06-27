package com.Soham.Module_4_Prod_Ready_features.Repositories;


import com.Soham.Module_4_Prod_Ready_features.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
