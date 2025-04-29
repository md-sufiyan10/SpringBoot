package com.sufi.tech.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sufi.tech.entity.College;

@Repository
public interface CollegeRepository extends JpaRepository<College,Long> {

}
