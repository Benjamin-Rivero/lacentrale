package fr.hb.lacentrale.controller;

import fr.hb.lacentrale.dto.ImageDto;
import fr.hb.lacentrale.entity.Image;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.ImageService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/image")
public class ImageController {


    private final ImageService imageService;

    @PostMapping
    public Image create(@Valid @RequestBody ImageDto imageDto){
        return imageService.create(imageDto);
    }

    @GetMapping("/{id}")
    public Image show(@PathVariable String id){
        return imageService.findById(id);
    }

    @GetMapping
    public List<Image> list(){
        return imageService.list();
    }

}