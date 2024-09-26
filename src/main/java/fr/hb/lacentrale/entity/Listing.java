package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewListing;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViewListing.Uuid.class)
    private String uuid;

    @Column(nullable = false)
    @JsonView(JsonViewListing.Price.class)
    private Long price;

    @Column(nullable = false)
    @JsonView(JsonViewListing.Mileage.class)
    private Long mileage;

    @Column(nullable = false)
    @JsonView(JsonViewListing.ProducedAt.class)
    private LocalDateTime producedAt;

    @Column(nullable = false)
    @JsonView(JsonViewListing.CreatedAt.class)
    private LocalDateTime createdAt;

    @Column(nullable = false,columnDefinition = "TEXT")
    @JsonView(JsonViewListing.Description.class)
    private String description;

    @Column(nullable = false)
    @JsonView(JsonViewListing.Title.class)
    private String title;

    @ManyToOne
    @JsonView(JsonViewListing.Address.class)
    private Address address;

    @ManyToOne
    @JsonView(JsonViewListing.Owner.class)
    private User owner;

    @ManyToOne
    @JsonView(JsonViewListing.Model.class)
    private Model model;

    @ManyToOne
    @JsonView(JsonViewListing.Fuel.class)
    private Fuel fuel;

    @OneToMany
    @JoinColumn(name = "listingUuid")
    @JsonView(JsonViewListing.Images.class)
    private List<Image> images;

}