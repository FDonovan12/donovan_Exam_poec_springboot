package fr.donovan.exam.centrale_ish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.interfaces.EntityInterface;
import fr.donovan.exam.centrale_ish.entity.interfaces.SluggerInterface;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsBrand;
import jakarta.persistence.*;
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
@Entity
public class Brand implements EntityInterface, SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsBrand.Id.class)
    private Long id;

    @JsonView(JsonViewsBrand.Name.class)
    private String name;

    @JsonView(JsonViewsBrand.Slug.class)
    private String slug;

    @Override
    public String getField() {
        return name;
    }
}