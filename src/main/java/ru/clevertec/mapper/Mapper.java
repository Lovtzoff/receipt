package ru.clevertec.mapper;

/**
 * Интерфейс конвертации сущности в DTO и обратно.
 *
 * @param <D> параметр Dto
 * @param <E> параметр Entity
 *
 * @author Lovtsov Aliaksei
 */
public interface Mapper<D, E> {

    /**
     * Конвертация в Dto.
     *
     * @param entity the entity
     * @return the dto
     */
    D toDto(E entity);

    /**
     * Конвертация в Entity.
     *
     * @param dto the dto
     * @return the entity
     */
    E toEntity(D dto);
}
