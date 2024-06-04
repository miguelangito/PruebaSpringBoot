package com.riwi.PruebaSpringBoot.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.riwi.PruebaSpringBoot.domain.entities.OptionQuestion;

@Repository
public interface OptionsRepository extends JpaRepository<OptionQuestion, Long>{
    
}
