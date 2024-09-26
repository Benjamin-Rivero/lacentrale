package fr.hb.lacentrale.controller;

import fr.hb.lacentrale.dto.ModelDto;
import fr.hb.lacentrale.entity.Model;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import fr.hb.lacentrale.service.ModelService;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/api/model")
public class ModelController {


    private final ModelService modelService;

    @PostMapping
    public Model create(@Valid @RequestBody ModelDto modelDto){
        return modelService.create(modelDto);
    }

    @GetMapping("/{id}")
    public Model show(@PathVariable Long id){
        return modelService.findById(id);
    }

    @GetMapping
    public List<Model> list(){
        return modelService.list();
    }

}