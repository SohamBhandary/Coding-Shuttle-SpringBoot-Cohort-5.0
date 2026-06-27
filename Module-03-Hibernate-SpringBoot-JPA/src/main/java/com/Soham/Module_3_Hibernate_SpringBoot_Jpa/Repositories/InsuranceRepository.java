package com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Repositories;

import com.Soham.Module_3_Hibernate_SpringBoot_Jpa.Entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InsuranceRepository extends JpaRepository<Insurance,Long> {
}
