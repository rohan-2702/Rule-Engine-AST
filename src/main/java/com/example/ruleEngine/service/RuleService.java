package com.example.ruleEngine.service;

import com.example.ruleEngine.entity.AstNode;
import com.example.ruleEngine.entity.Rule;
import com.example.ruleEngine.model.Node;
import com.example.ruleEngine.repository.RuleRepository;
import com.example.ruleEngine.repository.AstNodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    @Autowired
    private RuleRepository ruleRepository;

    @Autowired
    private AstNodeRepository astNodeRepository;

    // Save rule and its AST
    public Rule saveRuleWithAst(String ruleText, Node astRoot) {
        Rule rule = new Rule(ruleText);
        rule = ruleRepository.save(rule);

        saveAstNode(astRoot, rule);
        return rule;
    }

    private AstNode saveAstNode(Node node, Rule rule) {
        AstNode astNode = new AstNode(rule, node.getType(), node.getValue(), null, null);
        astNode = astNodeRepository.save(astNode);

        if (node.getLeft() != null) {
            astNode.setLeftChild(saveAstNode(node.getLeft(), rule));
        }
        if (node.getRight() != null) {
            astNode.setRightChild(saveAstNode(node.getRight(), rule));
        }

        return astNode;
    }

}
