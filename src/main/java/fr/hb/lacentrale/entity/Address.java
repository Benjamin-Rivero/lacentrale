package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;
import fr.hb.lacentrale.json_views.JsonViewAddress;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewAddress.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViewAddress.StreetNumber.class)
    private String streetNumber;

    @Column(nullable = false)
    @JsonView(JsonViewAddress.StreetName.class)
    private String streetName;

    @Column(nullable = false)
    @JsonView(JsonViewAddress.ZipCode.class)
    private String zipCode;

    @Column(nullable = false)
    @JsonView(JsonViewAddress.City.class)
    private String city;

    @Column(nullable = false)
    @JsonView(JsonViewAddress.Latitude.class)
    private String latitude;

    @Column(nullable = false)
    @JsonView(JsonViewAddress.Longitude.class)
    private String longitude;

    @OneToOne
    @JsonView(JsonViewAddress.User.class)
    private User user;

}