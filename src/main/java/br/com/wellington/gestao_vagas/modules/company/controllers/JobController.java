package br.com.wellington.gestao_vagas.modules.company.controllers;

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
    public JobEntity create(@Valid @RequestBody JobEntity jobEntity, HttpServletRequest request) {
        var companyid = request.getAttribute("company_id");
        jobEntity.setCompanyId(UUID.fromString(companyid.toString()));
        return this.createJobService.execute(jobEntity);
    }
}
