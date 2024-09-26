package fr.hb.lacentrale.service;

import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.FavoriteDto;
import fr.hb.lacentrale.entity.Favorite;
import fr.hb.lacentrale.service.interfaces.ServiceInterface;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.repository.FavoriteRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FavoriteService implements ServiceListInterface<Favorite, Long, FavoriteDto, FavoriteDto>, DtoMapperInterface<Favorite, FavoriteDto> {

    private final FavoriteRepository favoriteRepository;
    private final UserService userService;
    private final ListingService listingService;

    @Override
    public Favorite create(FavoriteDto favoriteDto) {
        return favoriteRepository.saveAndFlush(toEntity(favoriteDto));
    }

    @Override
    public void delete(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }

    @Override
    public Favorite update(FavoriteDto favoriteDto, Long id) {
        Favorite favorite = toEntity(favoriteDto);
        favorite.setId(id);
        favoriteRepository.saveAndFlush(favorite);
        return favorite;
    }

    @Override
    public Favorite findById(Long id) {
        return favoriteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public Favorite toEntity(FavoriteDto favoriteDto) {
        Favorite favorite = new Favorite();
        favorite.setCreatedAt(favoriteDto.getCreatedAt());
        favorite.setUser(userService.findById(favoriteDto.getUserUuid()));
        favorite.setListing(listingService.findById(favoriteDto.getListingUuid()));
        return favorite;
    }

    @Override
    public FavoriteDto toDto(Favorite favorite) {
        return null;
    }

    @Override
    public List<Favorite> list() {
        return favoriteRepository.findAll();
    }
}