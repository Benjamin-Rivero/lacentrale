package fr.hb.lacentrale.service;

import fr.hb.lacentrale.entity.User;
import fr.hb.lacentrale.repository.UserRepository;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.AddressDto;
import fr.hb.lacentrale.entity.Address;
import fr.hb.lacentrale.service.interfaces.ServiceInterface;
import fr.hb.lacentrale.repository.AddressRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class AddressService implements ServiceListInterface<Address, Long, AddressDto, AddressDto>, DtoMapperInterface<Address,AddressDto> {

    private final AddressRepository addressRepository;
    private final UserService userService;
    private final UserRepository userRepository;

    @Override
    public Address create(AddressDto addressDto) {
        Address address = toEntity(addressDto);
        addressRepository.saveAndFlush(address);
        if(addressDto.getUserId() != null) {
            User user = userService.findById(addressDto.getUserId());
            address.setUser(user);
            user.setAddress(address);
            userRepository.saveAndFlush(user);
        }
        return addressRepository.saveAndFlush(address);
    }

    @Override
    public void delete(Address address) {
        addressRepository.delete(address);
    }

    @Override
    public Address update(AddressDto addressDto, Long id) {
        Address address = toEntity(addressDto);
        address.setId(id);
        addressRepository.saveAndFlush(address);
        return address;
    }

    @Override
    public Address findById(Long id) {
        return addressRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public Address toEntity(AddressDto addressDto) {
        Address address = new Address();
        address.setStreetNumber(addressDto.getStreetNumber());
        address.setStreetName(addressDto.getStreetName());
        address.setZipCode(addressDto.getZipCode());
        address.setCity(addressDto.getCity());
        address.setLatitude(addressDto.getLatitude());
        address.setLongitude(addressDto.getLongitude());

        return address;
    }

    @Override
    public AddressDto toDto(Address entity) {
        return null;
    }

    @Override
    public List<Address> list() {
        return addressRepository.findAll();
    }
}