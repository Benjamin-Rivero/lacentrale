package fr.hb.lacentrale.service;

import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.ImageDto;
import fr.hb.lacentrale.entity.Image;
import fr.hb.lacentrale.service.interfaces.ServiceInterface;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.repository.ImageRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class ImageService implements ServiceListInterface<Image, String, ImageDto, ImageDto>, DtoMapperInterface<Image, ImageDto> {

    private final ImageRepository imageRepository;

    @Override
    public Image create(ImageDto imageDto) {
        return imageRepository.saveAndFlush(toEntity(imageDto));
    }

    @Override
    public void delete(Image image) {
        imageRepository.delete(image);
    }

    @Override
    public Image update(ImageDto imageDto, String id) {
        Image image = toEntity(imageDto);
        image.setUuid(id);
        imageRepository.saveAndFlush(image);
        return image;
    }

    @Override
    public Image findById(String id) {
        return imageRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public Image toEntity(ImageDto imageDto) {
        Image image = new Image();
        image.setPath(imageDto.getPath());
        return image;
    }

    @Override
    public ImageDto toDto(Image image) {
        return null;
    }

    @Override
    public List<Image> list() {
        return imageRepository.findAll();
    }
}