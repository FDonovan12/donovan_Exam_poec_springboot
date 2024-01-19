package fr.donovan.exam.centrale_ish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.interfaces.EntityInterface;
import fr.donovan.exam.centrale_ish.entity.interfaces.SluggerInterface;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsListing;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Listing implements EntityInterface, SluggerInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsListing.Id.class)
    private Long id;

    @JsonView(JsonViewsListing.Title.class)
    private String title;

    @JsonView(JsonViewsListing.Description.class)
    private String description;

    @JsonView(JsonViewsListing.ProducedYear.class)
    private int producedYear;

    @JsonView(JsonViewsListing.Mileage.class)
    private Long mileage;

    @JsonView(JsonViewsListing.Price.class)
    private Long price;

    @CreationTimestamp
    @JsonView(JsonViewsListing.CreatedAt.class)
    private Date createdAt;

    @JsonView(JsonViewsListing.Image.class)
    private String image;

    @JsonView(JsonViewsListing.Slug.class)
    private String slug;

    @ManyToOne
    @JsonView(JsonViewsListing.User.class)
    private User user;

    @ManyToOne
    @JsonView(JsonViewsListing.Model.class)
    private Model model;

    @Override
    public String getField() {
        return "vente-" + model.getBrand().getName() +
                "-" + model.getName() +
                "-" + producedYear +
                "-" + mileage;
    }

    public double getPrice() {
        return price/100;
    }
}