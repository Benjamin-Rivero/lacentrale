package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewModel.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViewModel.Name.class)
    private String name;

    @ManyToOne
    @JsonView(JsonViewModel.Brand.class)
    private Brand brand;

}