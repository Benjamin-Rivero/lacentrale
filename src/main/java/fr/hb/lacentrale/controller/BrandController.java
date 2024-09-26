package fr.hb.lacentrale.controller;

import fr.hb.lacentrale.dto.BrandDto;
import fr.hb.lacentrale.entity.Brand;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.BrandService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/brand")
public class BrandController {


    private final BrandService brandService;

    @PostMapping
    public Brand create(@Valid @RequestBody BrandDto brandDto){
        return brandService.create(brandDto);
    }

    @GetMapping("/{id}")
    public Brand show(@PathVariable Long id){
        return brandService.findById(id);
    }

    @GetMapping
    public List<Brand> list(){
        return brandService.list();
    }

}