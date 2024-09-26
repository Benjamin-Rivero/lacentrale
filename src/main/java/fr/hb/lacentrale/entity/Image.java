package fr.hb.lacentrale.entity;

import com.fasterxml.jackson.annotation.JsonView;
import fr.hb.lacentrale.json_views.JsonViewImage;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonView(JsonViewImage.Uuid.class)
    private String uuid;

    @Column(nullable = false, columnDefinition = "TEXT")
    @JsonView(JsonViewImage.Path.class)
    private String path;

}