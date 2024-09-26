package fr.hb.lacentrale.service;

import fr.hb.lacentrale.service.interfaces.ServiceListInterface;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fr.hb.lacentrale.dto.FuelDto;
import fr.hb.lacentrale.entity.Fuel;
import fr.hb.lacentrale.service.interfaces.ServiceInterface;
import fr.hb.lacentrale.service.interfaces.DtoMapperInterface;
import fr.hb.lacentrale.repository.FuelRepository;

import java.util.List;

@Repository
@AllArgsConstructor
public class FuelService implements ServiceListInterface<Fuel, Long, FuelDto, FuelDto>, DtoMapperInterface<Fuel, FuelDto> {

    private final FuelRepository fuelRepository;

    @Override
    public Fuel create(FuelDto fuelDto) {
        return fuelRepository.saveAndFlush(toEntity(fuelDto));
    }

    @Override
    public void delete(Fuel fuel) {
        fuelRepository.delete(fuel);
    }

    @Override
    public Fuel update(FuelDto fuelDto, Long id) {
        Fuel fuel = toEntity(fuelDto);
        fuel.setId(id);
        fuelRepository.saveAndFlush(fuel);
        return fuel;
    }

    @Override
    public Fuel findById(Long id) {
        return fuelRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }


    @Override
    public Fuel toEntity(FuelDto fuelDto) {
        Fuel fuel = new Fuel();
        fuel.setLogo(fuelDto.getLogo());
        fuel.setType(fuelDto.getType());
        return fuel;
    }

    @Override
    public FuelDto toDto(Fuel fuel) {
        return null;
    }

    @Override
    public List<Fuel> list() {
        return fuelRepository.findAll();
    }
}