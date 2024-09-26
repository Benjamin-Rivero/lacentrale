package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewFavorite;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewFavorite.Id.class)
    private Long id;

    @JsonView(JsonViewFavorite.CreatedAt.class)
    private LocalDateTime createdAt;

    @ManyToOne
    @JsonView(JsonViewFavorite.User.class)
    private User user;

    @ManyToOne
    @JsonView(JsonViewFavorite.Listing.class)
    private Listing listing;

}