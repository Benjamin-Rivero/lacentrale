package fr.hb.lacentrale.service;

import fr.hb.lacentrale.entity.Listing;
import fr.hb.lacentrale.entity.User;
import fr.hb.lacentrale.entity.embeddable.UserListingId;
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

import java.time.LocalDateTime;
import java.util.List;

@Repository
@AllArgsConstructor
public class FavoriteService{

    private final FavoriteRepository favoriteRepository;
    private final UserService userService;
    private final ListingService listingService;

    public Favorite create(UserListingId userListingId) {
        return favoriteRepository.saveAndFlush(toEntity(userListingId));
    }

    public void delete(Favorite favorite) {
        favoriteRepository.delete(favorite);
    }

    public Favorite findById(Long id) {
        return favoriteRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }



    public Favorite toEntity(UserListingId userListingId) {
        Favorite favorite = new Favorite();
        favorite.setId(userListingId);
        Listing listing = listingService.findById(userListingId.getListingId());
        User user = userService.findById(userListingId.getUserId());
        favorite.setCreatedAt(LocalDateTime.now());
        favorite.setUser(user);
        favorite.setListing(listing);
        return favorite;
    }

    public List<Favorite> list() {
        return favoriteRepository.findAll();
    }
}