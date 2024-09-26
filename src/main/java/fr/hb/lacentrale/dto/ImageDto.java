package fr.hb.lacentrale.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ImageDto {

    @NotBlank
    private String path;

}