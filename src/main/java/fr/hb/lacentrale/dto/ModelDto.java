package fr.hb.lacentrale.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ModelDto {

    @NotBlank
    private String name;

    @NotNull
    private Long brandId;

}