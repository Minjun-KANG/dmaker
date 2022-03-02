package com.fastcampus.programming.dmaker.repository;

import com.fastcampus.programming.dmaker.entitiy.Developer;
import com.fastcampus.programming.dmaker.entitiy.RetiredDeveloper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RetiredDeveloperRepository
        extends JpaRepository<RetiredDeveloper, Long> {

}
