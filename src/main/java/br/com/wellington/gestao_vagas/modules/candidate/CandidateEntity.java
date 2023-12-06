package br.com.wellington.gestao_vagas.modules.candidate;

import jakarta.validation.constraints.Pattern;
import lombok.Data;
import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.Length;

import java.util.UUID;
@Data
public class CandidateEntity {
    private UUID id;
    private String name;

    @Pattern(regexp = "^(?!\\s*$).+", message = "O campo [username] não deve conter espaço")
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido")
    private String email;

    @Length(min = 4, max = 5)
    private String password;
    private String description;
    private String curriculum;
}
