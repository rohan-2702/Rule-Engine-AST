package com.example.ruleEngine.repository;

import com.example.ruleEngine.entity.AstNode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstNodeRepository extends JpaRepository<AstNode, Long> {

}