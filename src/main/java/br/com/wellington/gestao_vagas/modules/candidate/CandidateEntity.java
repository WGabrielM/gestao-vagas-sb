package br.com.wellington.gestao_vagas.modules.candidate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;

import java.time.LocalDateTime;
import java.util.UUID;
@Data
@Getter
@Setter
@Entity(name = "candidate")
public class CandidateEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "^(?!\\s*$).+", message = "The field [username] must not contain spaces")
    @Schema(example = "Daniel" , requiredMode = RequiredMode.REQUIRED, description = "Candidate username")
    private String username;

    @Email(message = "The field [email] must contain a valid email")
    @Schema(example = "daniel@example.com", requiredMode = RequiredMode.REQUIRED, description = "Candidate email")
    private String email;

    @Length(min = 10, max = 100, message = "The password must contain between (10) and (100) characters")
    @Schema(example = "admin123", requiredMode = RequiredMode.REQUIRED, description = "Candidate password")
    private String password;
    @Schema(example = "java developer", requiredMode = RequiredMode.REQUIRED, description = "Candidate description")
    private String description;
    private String curriculum;

    @CreationTimestamp
    private LocalDateTime createdAt;

}
