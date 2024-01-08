package br.com.wellington.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;
@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @NotBlank()
    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 10, max = 100)
    private String password;
    private String description;
    private String curriculum;
}
