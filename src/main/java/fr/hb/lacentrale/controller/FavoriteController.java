package fr.hb.lacentrale.controller;

import fr.hb.lacentrale.dto.FavoriteDto;
import fr.hb.lacentrale.entity.Favorite;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.FavoriteService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/favorite")
public class FavoriteController {


    private final FavoriteService favoriteService;

    @PostMapping
    public Favorite create(@Valid @RequestBody FavoriteDto favoriteDto){
        return favoriteService.create(favoriteDto);
    }

    @GetMapping("/{id}")
    public Favorite show(@PathVariable Long id){
        return favoriteService.findById(id);
    }

    @GetMapping
    public List<Favorite> list(){
        return favoriteService.list();
    }

}