package fr.hb.lacentrale.service;

import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.BrandDto;
import fr.hb.lacentrale.entity.Brand;
import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import fr.hb.lacentrale.repository.BrandRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class BrandService implements ServiceListInterface<Brand, Long, BrandDto, BrandDto>, DtoMapperInterface<Brand,BrandDto> {

    private final BrandRepository brandRepository;

    @Override
    public Brand create(BrandDto brandDto) {
        return brandRepository.saveAndFlush(toEntity(brandDto));
    }

    @Override
    public void delete(Brand brand) {
        brandRepository.delete(brand);
    }

    @Override
    public Brand update(BrandDto brandDto, Long id) {
        Brand brand = toEntity(brandDto);
        brand.setId(id);
        brandRepository.saveAndFlush(brand);
        return brand;
    }

    @Override
    public Brand findById(Long id) {
        return brandRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Brand> list() {
        return brandRepository.findAll();
    }

    @Override
    public Brand toEntity(BrandDto brandDto) {
        Brand brand = new Brand();
        brand.setName(brandDto.getName());
        return brand;
    }

    @Override
    public BrandDto toDto(Brand entity) {
        return null;
    }

}