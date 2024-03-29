package br.com.wellington.gestao_vagas.modules.candidate.controllers;

import br.com.wellington.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.wellington.gestao_vagas.modules.candidate.services.CreateCandidateService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/candidate")
public class CandidateController {
    @Autowired
    private CreateCandidateService createCandidateService;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody CandidateEntity candidateEntity) {
        try {
            var result = this.createCandidateService.execute(candidateEntity);
            return ResponseEntity.ok().body(result);
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
