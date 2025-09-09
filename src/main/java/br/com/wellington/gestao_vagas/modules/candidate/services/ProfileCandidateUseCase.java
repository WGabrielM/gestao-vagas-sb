package br.com.wellington.gestao_vagas.modules.candidate.services;

import java.util.UUID;

import br.com.wellington.gestao_vagas.modules.candidate.CandidateRepository;
import br.com.wellington.gestao_vagas.modules.candidate.dto.ProfileCandidateResponseDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileCandidateUseCase {

    @Autowired
    private CandidateRepository candidateRepository;

    public ProfileCandidateResponseDTO execute(UUID idCandidate) {

        var candidate = this.candidateRepository.findById(idCandidate)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));
                
        var candidateDTO = ProfileCandidateResponseDTO.builder()
                .id(candidate.getId().toString())
                .name(candidate.getName())
                .email(candidate.getEmail())
                .username(candidate.getUsername())
                .description(candidate.getDescription())
                .build();
        return candidateDTO;
    }

}
