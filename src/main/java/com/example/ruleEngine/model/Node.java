package com.example.ruleEngine.model;

import java.util.List;

public class Node {
    private String type;  // "operator", "operand", or "root"
    private String value;
    private Node left;
    private Node right;
    private List<Node> children; // For root node containing multiple independent rules

    // Constructors
    public Node(String type, String value) {
        this.type = type;
        this.value = value;
    }

    public Node(String type, String value, Node left, Node right) {
        this.type = type;
        this.value = value;
        this.left = left;
        this.right = right;
    }

    // Constructor for root node
    public Node(String type, List<Node> children) {
        this.type = type;
        this.children = children;
    }

    // Getters and Setters
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

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }
}
