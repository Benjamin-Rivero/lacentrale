package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewBrand;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewBrand.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViewBrand.Name.class)
    private String name;

    @OneToMany(mappedBy = "brand")
    @JsonView(JsonViewBrand.Models.class)
    private List<Model> model;

}