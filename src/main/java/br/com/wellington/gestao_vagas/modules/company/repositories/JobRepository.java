package br.com.wellington.gestao_vagas.modules.company.repositories;

import br.com.wellington.gestao_vagas.modules.company.entities.JobEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface JobRepository  extends JpaRepository<JobEntity, UUID> {
    // "contains" é o operador de LIKE do SQL
    // "filter" é o valor que será buscado na descrição da vaga

    List<JobEntity> findByDescriptionContaining(String filter);
}
