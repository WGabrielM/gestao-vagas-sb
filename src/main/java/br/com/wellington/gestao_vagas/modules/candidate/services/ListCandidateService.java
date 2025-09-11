package br.com.wellington.gestao_vagas.modules.candidate.services;

import br.com.wellington.gestao_vagas.modules.candidate.CandidateEntity;
import br.com.wellington.gestao_vagas.modules.candidate.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListCandidateService {

    @Autowired
    private CandidateRepository candidateRepository;

    public List<CandidateEntity> execute() {
        return this.candidateRepository.findAll();
    }
}
