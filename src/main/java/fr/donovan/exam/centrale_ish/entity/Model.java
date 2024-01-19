package fr.donovan.exam.centrale_ish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.interfaces.EntityInterface;
import fr.donovan.exam.centrale_ish.entity.interfaces.SluggerInterface;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsModel;
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
public class Model implements EntityInterface, SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsModel.Id.class)
    private Long id;

    @JsonView(JsonViewsModel.Name.class)
    private String name;

    @JsonView(JsonViewsModel.Slug.class)
    private String slug;

    @ManyToOne
    @JsonView(JsonViewsModel.Brand.class)
    private Brand brand;

    @Override
    public String getField() {
        return name;
    }
}