package ru.clevertec.mapper;

import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.model.DiscountCard;

/**
 * Реализация интерфейса Mapper для DiscountCard.
 *
 * @author Lovtsov Aliaksei
 * @see Mapper
 */
public class DiscountCardMapper implements Mapper<DiscountCardDto, DiscountCard> {

    @Override
    public DiscountCardDto toDto(DiscountCard card) {
        return DiscountCardDto.builder()
                .id(card.getId())
                .discount(card.getDiscount())
                .build();
    }

    @Override
    public DiscountCard toEntity(DiscountCardDto dto) {
        return DiscountCard.builder()
                .id(dto.getId())
                .discount(dto.getDiscount())
                .build();
    }
}
