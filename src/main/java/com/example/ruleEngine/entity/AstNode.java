package com.example.ruleEngine.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ast_nodes")
public class AstNode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "rule_id")
    private Rule rule;  // Ensure this is your entity Rule class

    private String type;
    private String value;

    @ManyToOne
    @JoinColumn(name = "left_child_id")
    private AstNode leftChild;

    @ManyToOne
    @JoinColumn(name = "right_child_id")
    private AstNode rightChild;

    // Constructors
    public AstNode() {}

    public AstNode(Rule rule, String type, String value, AstNode leftChild, AstNode rightChild) {
        this.rule = rule;
        this.type = type;
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    // Getters and Setters...

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Rule getRule() {
        return rule;
    }

    public void setRule(Rule rule) {
        this.rule = rule;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public AstNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(AstNode leftChild) {
        this.leftChild = leftChild;
    }

    public AstNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(AstNode rightChild) {
        this.rightChild = rightChild;
    }
}
