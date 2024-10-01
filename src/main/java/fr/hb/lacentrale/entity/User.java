package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewUser;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViewUser.Uuid.class)
    private String uuid;

    @JsonView(JsonViewUser.FirstName.class)
    private String firstName;

    @JsonView(JsonViewUser.LastName.class)
    private String lastName;


    @Column(nullable = false)
    @JsonView(JsonViewUser.Email.class)
    private String email;

    @Column(nullable = false)
    @JsonView(JsonViewUser.Password.class)
    private String password;

    @JsonView(JsonViewUser.Phone.class)
    private String phone;

    @JsonView(JsonViewUser.Siret.class)
    private String siret;

    @JsonView(JsonViewUser.Photo.class)
    private String photo;

    @JsonView(JsonViewUser.ActivationCode.class)
    private String activationCode;

    private LocalDateTime activationCodeSentAt;

    @JsonView(JsonViewUser.BirthAt.class)
    private LocalDate birthAt;

    @Column(nullable = false)
    @JsonView(JsonViewUser.CreatedAt.class)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    @JsonView(JsonViewUser.Roles.class)
    private String roles;

    @OneToMany(mappedBy = "owner")
    @JsonView(JsonViewUser.Listings.class)
    private List<Listing> listings;

    @OneToMany(mappedBy = "user")
    @JsonView(JsonViewUser.Favorites.class)
    private List<Favorite> favorites;

    @OneToOne(mappedBy = "user")
    @JsonView(JsonViewUser.Address.class)
    private Address address;

    @JsonView(JsonViewUser.Active.class)
    private Boolean getIsActive() {
        return activationCode == null;
    }

    @JsonView(JsonViewUser.IsAdmin.class)
    private Boolean getIsAdmin() {
        return roles.contains("ROLE_ADMIN");
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isEnabled() {
        return getIsActive();
    }
}