package fr.hb.lacentrale.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDto {

    @NotBlank
    private String streetNumber;

    @NotBlank
    private String streetName;

    @NotBlank
    private String zipCode;

    @NotBlank
    private String city;

    @NotBlank
    private String latitude;

    @NotBlank
    private String longitude;

    private String userId;

}