package fr.hb.lacentrale.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class FavoriteDto {

    @NotNull
    private String userUuid;

    @NotNull
    private String listingUuid;

    @NotNull
    private LocalDateTime createdAt;

}