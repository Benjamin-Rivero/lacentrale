package fr.hb.lacentrale.service.interfaces;

public interface DtoMapperInterface<T,DTO> {

    T toEntity(DTO dto);

    DTO toDto(T entity);

}
