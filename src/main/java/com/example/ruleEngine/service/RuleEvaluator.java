package com.example.ruleEngine.service;

import com.example.ruleEngine.model.Node;

import java.util.Map;

public class RuleEvaluator {
    // Method to evaluate the AST against the provided data
    public boolean evaluate(Node node, Map<String, Object> data) {
        if (node == null) {
            return false; // Empty tree
        }

        switch (node.getType()) {
            case "operand":
                return evaluateOperand(node, data);
            case "operator":
                return evaluateOperator(node, data);
            default:
                return false;
        }
    }

    private boolean evaluateOperand(Node node, Map<String, Object> data) {
        String[] parts = node.getValue().split(" ");

        // Check if the parts array has at least 3 elements
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid operand format: " + node.getValue());
        }

        String attribute = parts[0];
        String operator = parts[1];
        Object value = parseValue(parts[2]);

        if (!data.containsKey(attribute)) {
            return false; // Attribute not present in data
        }

        Object attributeValue = data.get(attribute);
        return evaluateCondition(attributeValue, operator, value);
    }


    private boolean evaluateOperator(Node node, Map<String, Object> data) {
        String operator = node.getValue();
        boolean leftValue = evaluate(node.getLeft(), data);
        boolean rightValue = evaluate(node.getRight(), data);

        return switch (operator) {
            case "AND" -> leftValue && rightValue;
            case "OR" -> leftValue || rightValue;
            default -> false;
        };
    }

    private Object parseValue(String value) {
        // Handle parsing for different types (int, string, etc.)
        if (value.matches("\\d+")) { // integer
            return Integer.parseInt(value);
        } else if (value.startsWith("\"") && value.endsWith("\"")) { // string
            return value.substring(1, value.length() - 1);
        }
        return value; // Default case
    }

    private boolean evaluateCondition(Object attributeValue, String operator, Object ruleValue) {
        switch (operator) {
            case ">" -> {
                return (Integer) attributeValue > (Integer) ruleValue;
            }
            case "<" -> {
                return (Integer) attributeValue < (Integer) ruleValue;
            }
            case "=" -> {
                return attributeValue.equals(ruleValue);
            }
            case ">=" -> {
                return (Integer) attributeValue >= (Integer) ruleValue;
            }
            case "<=" -> {
                return (Integer) attributeValue <= (Integer) ruleValue;
            }
            case "!=" -> {
                return !attributeValue.equals(ruleValue);
            }
            default -> throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }
}