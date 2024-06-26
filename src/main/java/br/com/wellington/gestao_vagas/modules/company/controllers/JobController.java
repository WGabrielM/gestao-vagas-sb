package br.com.wellington.gestao_vagas.modules.company.controllers;

import br.com.wellington.gestao_vagas.modules.company.dto.CreateJobDTO;
import br.com.wellington.gestao_vagas.modules.company.entities.JobEntity;
import br.com.wellington.gestao_vagas.modules.company.services.CreateJobService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/job")
public class JobController {

    @Autowired
    private CreateJobService createJobService;

    @PostMapping("/")
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
