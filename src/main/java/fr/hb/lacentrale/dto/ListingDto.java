package fr.hb.lacentrale.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ListingDto {

    @NotNull
    private Long price;

    @NotNull
    private Long mileage;

    @NotNull
    private LocalDateTime producedAt;

    @NotNull
    private LocalDateTime createdAt;

    @NotBlank
    private String description;

    @NotBlank
    private String title;

    @NotNull
    private AddressDto addressDto;

    @NotBlank
    private String ownerUuid;

    @NotNull
    private Long modelId;

    @NotNull
    private Long fuelId;

}