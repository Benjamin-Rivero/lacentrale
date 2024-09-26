package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewFuel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Fuel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(JsonViewFuel.Id.class)
    private Long id;

    @Column(nullable = false)
    @JsonView(JsonViewFuel.Type.class)
    private String type;

    @Column(nullable = false)
    @JsonView(JsonViewFuel.Logo.class)
    private String logo;
}