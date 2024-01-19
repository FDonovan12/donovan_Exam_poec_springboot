package fr.donovan.exam.centrale_ish.DTO;

import fr.donovan.exam.centrale_ish.repository.ModelRepository;
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
public class ModelDTO {

    @NotBlank(message = "This should be a valid name")
    private String name;

    @NotNull(message = "This should be not null")
    @Min(message = "This should greater than 0", value = 1)
    private Long brand_id;
}