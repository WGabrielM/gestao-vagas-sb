package br.com.wellington.gestao_vagas.modules.candidate.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProfileCandidateResponseDTO {

    private String id;
    @Schema(description = "Candidate name", example = "Maria Silva", requiredMode = RequiredMode.REQUIRED)
    private String name;
    @Schema(description = "Candidate email", example = "maria@example.com", requiredMode = RequiredMode.REQUIRED)
    private String email;
    @Schema(description = "Candidate username", example = "maria", requiredMode = RequiredMode.REQUIRED)
    private String username;
    @Schema(description = "Candidate description", example = "Java Developer", requiredMode = RequiredMode.REQUIRED)
    private String description;
}
