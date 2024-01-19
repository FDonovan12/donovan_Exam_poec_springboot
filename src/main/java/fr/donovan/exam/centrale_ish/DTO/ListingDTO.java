package fr.donovan.exam.centrale_ish.DTO;

import fr.donovan.exam.centrale_ish.repository.ListingRepository;
import fr.donovan.exam.centrale_ish.validator.annotation.UniqueName;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ListingDTO {

    @NotBlank(message = "This should be a valid title")
    private String title;

    @NotBlank(message = "This should be a valid description")
    private String description;

    @NotNull(message = "This should be a valid producedYear")
    private int producedYear;

    @NotNull(message = "This should be a valid mileage")
    private Long mileage;

    @NotNull(message = "This should be a valid price")
    private Long price;

    private String image;

    @Min(message = "This should greater than 0", value = 1)
    private Long model_id;
}