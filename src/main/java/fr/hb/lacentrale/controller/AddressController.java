package fr.hb.lacentrale.controller;

import fr.hb.lacentrale.dto.AddressDto;
import fr.hb.lacentrale.entity.Address;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.AddressService;


@AllArgsConstructor
@RestController
@RequestMapping("/api/address")
public class AddressController {


    private final AddressService addressService;

    @PostMapping
    public Address create(@Valid @RequestBody AddressDto addressDto){
        return addressService.create(addressDto);
    }

}