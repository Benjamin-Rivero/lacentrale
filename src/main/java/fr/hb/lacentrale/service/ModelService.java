package fr.hb.lacentrale.service;

import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.ModelDto;
import fr.hb.lacentrale.entity.Model;
import fr.hb.lacentrale.service.interfaces.ServiceInterface;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.repository.ModelRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ModelService implements ServiceListInterface<Model, Long, ModelDto, ModelDto>, DtoMapperInterface<Model, ModelDto> {

    private final ModelRepository modelRepository;
    private final BrandService brandService;

    @Override
    public Model create(ModelDto modelDto) {
        return modelRepository.saveAndFlush(toEntity(modelDto));
    }

    @Override
    public void delete(Model model) {
        modelRepository.delete(model);
    }

    @Override
    public Model update(ModelDto modelDto, Long id) {
        Model model = toEntity(modelDto);
        model.setId(id);
        return modelRepository.saveAndFlush(model);
    }

    @Override
    public Model findById(Long id) {
        return modelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public Model toEntity(ModelDto modelDto) {
        Model model = new Model();
        model.setName(modelDto.getName());
        model.setBrand(brandService.findById(modelDto.getBrandId()));
        return model;
    }

    @Override
    public ModelDto toDto(Model model) {
        return null;
    }

    @Override
    public List<Model> list() {
        return modelRepository.findAll();
    }
}