package com.Soham.Module_5_Spring_Security_Fundamentals.Repositories;


import com.Soham.Module_5_Spring_Security_Fundamentals.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
}
