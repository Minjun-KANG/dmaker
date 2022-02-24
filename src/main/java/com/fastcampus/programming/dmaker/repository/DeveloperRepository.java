package com.fastcampus.programming.dmaker.repository;

import com.fastcampus.programming.dmaker.entitiy.Developer;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeveloperRepository
        extends JpaRepository<Developer, Long> {

}
