package fr.donovan.exam.centrale_ish.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.donovan.exam.centrale_ish.entity.interfaces.EntityInterface;
import fr.donovan.exam.centrale_ish.entity.interfaces.SluggerInterface;
import fr.donovan.exam.centrale_ish.json_views.JsonViewsUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class User implements EntityInterface, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewsUser.Id.class)
    private Long id;

    @CreationTimestamp
    @JsonView(JsonViewsUser.CreatedAt.class)
    private Date createdAt;

    @JsonView(JsonViewsUser.Email.class)
    private String email;

    @JsonView(JsonViewsUser.Password.class)
    private String password;

    @JsonView(JsonViewsUser.Roles.class)
    private String roles = "[]";

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViewsUser.Listings.class)
    private List<Listing> listings = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}