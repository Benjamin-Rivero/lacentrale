package fr.hb.lacentrale.service;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.ListingDto;
import fr.hb.lacentrale.entity.Listing;
import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.repository.ListingRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ListingService implements ServiceListInterface<Listing, String, ListingDto, ListingDto>, DtoMapperInterface<Listing, ListingDto> {

    private final ListingRepository listingRepository;
    private final AddressService addressService;
    private final UserService userService;
    private final ModelService modelService;
    private final FuelService fuelService;

    @Override
    public Listing create(ListingDto listingDto) {
        return listingRepository.saveAndFlush(toEntity(listingDto));
    }

    @Override
    public void delete(Listing listing) {
        listingRepository.delete(listing);
    }

    @Override
    public Listing update(ListingDto listingDto, String id) {
        Listing listing = toEntity(listingDto);
        listing.setUuid(id);
        return listingRepository.saveAndFlush(listing);
    }

    @Override
    public Listing findById(String id) {
        return listingRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Listing> list() {
        return listingRepository.findAll();
    }

    @Override
    public Listing toEntity(ListingDto listingDto) {
        Listing listing = new Listing();
        listing.setPrice(listingDto.getPrice());
        listing.setMileage(listingDto.getMileage());
        listing.setProducedAt(listingDto.getProducedAt());
        listing.setCreatedAt(listingDto.getCreatedAt());
        listing.setDescription(listingDto.getDescription());
        listing.setTitle(listingDto.getTitle());
        listing.setAddress(addressService.create(listingDto.getAddressDto()));
        listing.setOwner(userService.findById(listingDto.getOwnerUuid()));
        listing.setModel(modelService.findById(listingDto.getModelId()));
        listing.setFuel(fuelService.findById(listingDto.getModelId()));
        return listing;
    }

    @Override
    public ListingDto toDto(Listing listing) {
        return null;
    }

}