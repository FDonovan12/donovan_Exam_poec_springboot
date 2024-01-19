package fr.donovan.exam.centrale_ish.DTO;

import fr.donovan.exam.centrale_ish.repository.UserRepository;
import fr.donovan.exam.centrale_ish.validator.annotation.UniqueName;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDTO {

    @NotBlank(message = "This should be not blank")
    @Email(message = "This should be a valid email")
    private String email;

    @NotBlank(message = "This should be not blank")
    private String password;
}