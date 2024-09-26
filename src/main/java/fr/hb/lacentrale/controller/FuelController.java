package fr.hb.lacentrale.controller;

import fr.hb.lacentrale.dto.FuelDto;
import fr.hb.lacentrale.entity.Fuel;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.FuelService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/fuel")
public class FuelController {


    private final FuelService fuelService;

    @PostMapping
    public Fuel create(@Valid @RequestBody FuelDto fuelDto){
        return fuelService.create(fuelDto);
    }

    @GetMapping
    public List<Fuel> list(){
        return fuelService.list();
    }

}