package br.com.wellington.gestao_vagas.modules.company.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "job")
public class JobEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    @Schema(description = "Job description", example = "Design Position", requiredMode = RequiredMode.REQUIRED)
    private String description;

    @Schema(description = "Job benefits", example = "GYMPass, Health Insurance, etc.", requiredMode = RequiredMode.REQUIRED)
    private String benefits;

    @NotBlank(message = "This field is required")
    @Schema(description = "Job level", example = "Junior, Mid, Senior", requiredMode = RequiredMode.REQUIRED)
    private String level;

    @ManyToOne()
    @JoinColumn(name = "company_id", insertable = false, updatable = false)
    private CompanyEntity companyEntity;

    @Column(name = "company_id", nullable = false)
    private UUID companyId;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
