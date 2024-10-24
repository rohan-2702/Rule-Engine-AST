package com.example.ruleEngine.service;

import com.example.ruleEngine.exception.RuleParseException;
import com.example.ruleEngine.model.Node;

import java.util.*;

public class RuleParser {

    // Precedence map for operators
    private static final Map<String, Integer> precedence = new HashMap<>();
    static {
        precedence.put("AND", 1);
        precedence.put("OR", 1);
        precedence.put(">", 2);
        precedence.put("<", 2);
        precedence.put("=", 2);
    }

    // Convert the input rule to AST
    public Node parseRule(String rule) {
        List<String> tokens = tokenize(rule);
        validateTokens(tokens); // Validate tokens before building AST
        return buildAST(tokens);
    }

    // Validate tokens for errors
    private void validateTokens(List<String> tokens) {
        checkBalancedParentheses(tokens);
        checkOperatorRules(tokens);
        checkLogicalStructure(tokens); // New check for logical structure
    }

    // Check for balanced parentheses
    private void checkBalancedParentheses(List<String> tokens) {
        Stack<String> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("(")) {
                stack.push(token);
            } else if (token.equals(")")) {
                if (stack.isEmpty()) {
                    throw new RuleParseException("Invalid rule format: unmatched closing parenthesis.");
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            throw new RuleParseException("Invalid rule format: unmatched opening parenthesis.");
        }
    }

    // Check for invalid operator usage
    private void checkOperatorRules(List<String> tokens) {
        boolean lastWasOperator = false;

        for (String token : tokens) {
            if (isOperator(token)) {
                if (lastWasOperator) {
                    throw new RuleParseException("Invalid rule format: consecutive operators detected.");
                }
                lastWasOperator = true;
            } else if (isOperand(token)) {
                lastWasOperator = false; // Reset if we find an operand
            }
        }

        if (lastWasOperator) {
            throw new RuleParseException("Invalid rule format: rule ends with an operator.");
        }
    }

    // Check logical structure for AND/OR rules
    private void checkLogicalStructure(List<String> tokens) {
        boolean foundAnd = false;
        boolean foundOr = false;

        for (String token : tokens) {
            if (token.equals("AND")) {
                foundAnd = true;
            } else if (token.equals("OR")) {
                foundOr = true;
            }

            // If we find an OR but haven't found any ANDs before it
            if (foundOr && !foundAnd) {
                throw new RuleParseException("Invalid rule format: OR operator must be preceded by AND operator.");
            }
        }
    }

    // Tokenizer: Split rule into tokens
    private List<String> tokenize(String rule) {
        // Handle operators and parentheses as separate tokens
        return Arrays.asList(rule.split("\\s+"));
    }

    // Function to build AST from list of tokens
    private Node buildAST(List<String> tokens) {
        Stack<Node> nodes = new Stack<>();
        Stack<String> operators = new Stack<>();

        for (String token : tokens) {
            if (isOperand(token)) {
                // Create operand node
                nodes.push(new Node("operand", token));
            } else if (isOperator(token)) {
                // Process operator precedence
                while (!operators.isEmpty() && precedence.get(token) <= precedence.get(operators.peek())) {
                    nodes.push(createOperatorNode(operators.pop(), nodes.pop(), nodes.pop()));
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                // Pop operators until matching '('
                while (!operators.peek().equals("(")) {
                    nodes.push(createOperatorNode(operators.pop(), nodes.pop(), nodes.pop()));
                }
                operators.pop(); // Remove '('
            }
        }

        // Process remaining operators
        while (!operators.isEmpty()) {
            nodes.push(createOperatorNode(operators.pop(), nodes.pop(), nodes.pop()));
        }

        // Final node is the root of the AST
        return nodes.pop();
    }

    // Helper to check if token is an operand
    private boolean isOperand(String token) {
        return !isOperator(token) && !token.equals("(") && !token.equals(")");
    }

    // Helper to check if token is an operator
    private boolean isOperator(String token) {
        return precedence.containsKey(token);
    }

    // Create an operator node and combine its left and right children
    private Node createOperatorNode(String operator, Node right, Node left) {
        return new Node("operator", operator, left, right);
    }
}
