package br.com.wellington.gestao_vagas.modules.company.controllers;

import br.com.wellington.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.wellington.gestao_vagas.modules.company.entities.JobEntity;
import br.com.wellington.gestao_vagas.modules.company.services.CreateJobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/company/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping("/")
    @Tag(name = "Job Controller", description = "Job information")
    @Operation(summary = "Create a new job", description = "Function responsible for creating a new job")
    @ApiResponses({
        @ApiResponse(responseCode = "200", content = {
            @Content(schema = @Schema(implementation = JobEntity.class))
        }),
        @ApiResponse(responseCode = "400", content = {
            @Content(schema = @Schema(implementation = String.class))
        })
    })
    @SecurityRequirement(name = "jwt_auth")
    @PreAuthorize("hasRole('COMPANY')")
    public JobEntity create(@Valid @RequestBody CreateJobDTO createJobDTO, HttpServletRequest request) {
        var companyid = request.getAttribute("company_id");

        var jobEntity = JobEntity.builder()
                .benefits(createJobDTO.getBenefits())
                .companyId(UUID.fromString(companyid.toString()))
                .description(createJobDTO.getDescription())
                .level(createJobDTO.getLevel())
                .build();
        return this.createJobService.execute(jobEntity);
    }
}
