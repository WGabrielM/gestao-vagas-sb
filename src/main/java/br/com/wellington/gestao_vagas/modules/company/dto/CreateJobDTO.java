package br.com.wellington.gestao_vagas.modules.company.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import lombok.Data;

@Data
public class CreateJobDTO {

    @Schema(description = "Job description", example = "Job description", requiredMode = RequiredMode.REQUIRED)
    private String description;
    @Schema(description = "Job benefits", example = "GYMPass, Health Insurance, etc.", requiredMode = RequiredMode.REQUIRED)
    private String benefits;
    @Schema(description = "Job level", example = "Junior, Mid, Senior", requiredMode = RequiredMode.REQUIRED)
    private String level;
}
