package com.example.ruleEngine.controller;

import com.example.ruleEngine.entity.Rule;
import com.example.ruleEngine.model.Node;
import com.example.ruleEngine.repository.RuleRepository;
import com.example.ruleEngine.service.RuleEvaluator;
import com.example.ruleEngine.service.RuleParser;
import com.example.ruleEngine.service.RuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/rules")
public class RuleController {

    @Autowired
    private RuleRepository ruleRepository;
    private final RuleParser ruleParser = new RuleParser(); // Dependency
    private final RuleEvaluator ruleEvaluator = new RuleEvaluator(); // Dependency

    @Autowired
    private RuleService ruleService;

    @PostMapping("/create")
    public ResponseEntity<Node> parseRule(@RequestBody String rule) {
        try {
            String decodedRule = URLDecoder.decode(rule, StandardCharsets.UTF_8);
            Node ast = ruleParser.parseRule(decodedRule);
            ruleService.saveRuleWithAst(decodedRule,ast);
            return ResponseEntity.ok(ast);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Handle parsing errors
        }
    }


    @PostMapping("/combine")
    public ResponseEntity<Node> combineRules(@RequestBody List<String> rules) {
        List<Node> asts = new ArrayList<>();

        for (String rule : rules) {
            try {
                // Decode each rule in the list
                String decodedRule = URLDecoder.decode(rule, StandardCharsets.UTF_8);

                // Parse the decoded rule
                Node ast = ruleParser.parseRule(decodedRule);
                asts.add(ast);

                // Save the current rule and its AST in the database
                ruleService.saveRuleWithAst(decodedRule, ast);
            } catch (Exception e) {
                return ResponseEntity.badRequest().body(null); // Handle parsing errors
            }
        }

        // Create a root node containing all ASTs
        Node rootAst = new Node("root", asts);

        return ResponseEntity.ok(rootAst); // Return the root AST
    }


    @GetMapping("/all")
    public ResponseEntity<List<Rule>> findAllRules() {
        List<Rule> rules = ruleRepository.findAll();
        return ResponseEntity.ok(rules); // Return rules with HTTP 200 status
    }

}
