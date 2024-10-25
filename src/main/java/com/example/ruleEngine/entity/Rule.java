package com.example.ruleEngine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "rules")
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "rule_text", nullable = false)
    private String ruleText;

    // Constructors, Getters, and Setters
    public Rule() {}

    public Rule(String ruleText) {
        this.ruleText = ruleText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRuleText() {
        return ruleText;
    }

    public void setRuleText(String ruleText) {
        this.ruleText = ruleText;
    }
}