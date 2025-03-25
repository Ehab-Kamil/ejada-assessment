package com.ejada.assessment.controller;

import com.ejada.assessment.dto.BusinessruleDTO;
import com.ejada.assessment.service.BusinessRuleService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: BusinessRuleController.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright(c) Ehab Kamil, 2025
 * </p>
 *
 * @author <a href="mailto:ehabkamil2@gmail.com">Ehab Attia</a>
 * @version 1.0
 */
@RestController
@RequestMapping("/api/business_rule")
public class BusinessRuleController {

    @Autowired
    private BusinessRuleService businessRuleService;

    //    @Autowired
    //    private BusinessRuleTransformer businessRuleTransformer;

    @GetMapping
    public ResponseEntity<List<BusinessruleDTO>> getAllRules() {
        return ResponseEntity.ok(businessRuleService.getAll());
    }

    @PostMapping
    public ResponseEntity<BusinessruleDTO> createRule(@Valid @RequestBody BusinessruleDTO rule) {
        return ResponseEntity.status(HttpStatus.CREATED).body(businessRuleService.save(rule));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BusinessruleDTO> update(@PathVariable Long id, @Valid @RequestBody BusinessruleDTO rule) {
        BusinessruleDTO updateRule = businessRuleService.update(id, rule);
        return (updateRule != null) ? ResponseEntity.ok(updateRule) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return (businessRuleService.delete(id)) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }

}

