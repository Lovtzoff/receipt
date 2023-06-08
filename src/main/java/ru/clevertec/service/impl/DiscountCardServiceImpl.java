package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.dao.DiscountCardDao;
import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.mapper.DiscountCardMapper;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.service.DiscountCardService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static ru.clevertec.constants.Constants.DEFAULT_PAGE;
import static ru.clevertec.constants.Constants.DEFAULT_SIZE_PAGE;

/**
 * Реализация интерфейса DiscountCardService.
 *
 * @author Ловцов Алексей
 * @see DiscountCardService
 */
@Service
@RequiredArgsConstructor
public class DiscountCardServiceImpl implements DiscountCardService {

    /**
     * Получение данных из базы.
     */
    private final DiscountCardDao discountCardDao;
    /**
     * Конвертация сущности в DTO и обратно.
     */
    private final DiscountCardMapper cardMapper;

    @Override
    public DiscountCardDto findOneById(Integer id) {
        return discountCardDao.findById(id)
                .map(cardMapper::toDto)
                .orElse(new DiscountCardDto());
    }

    @Override
    public List<DiscountCardDto> findAll(String size, String page) {
        int pageSize = (size != null) ? Integer.parseInt(size) : DEFAULT_SIZE_PAGE;
        int pageNumber = (page != null) ? (Integer.parseInt(page) * pageSize) : DEFAULT_PAGE;

        List<DiscountCardDto> discountCards = discountCardDao.findAll(pageSize, pageNumber).stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
        if (!discountCards.isEmpty()) {
            return discountCards;
        }
        throw new ParameterNotFoundException("Ошибка чтения списка скидочных карт! База карт пуста!");
    }

    @Override
    public DiscountCardDto save(DiscountCardDto discountCardDto) {
        DiscountCard discountCard = cardMapper.toEntity(discountCardDto);
        return cardMapper.toDto(discountCardDao.add(discountCard));
    }

    @Override
    public DiscountCardDto update(DiscountCardDto discountCardDto, Integer id) {
        Optional<DiscountCard> optionalProduct = discountCardDao.findById(id);
        if (optionalProduct.isPresent()) {
            DiscountCard discountCard = cardMapper.toEntity(discountCardDto);
            return cardMapper.toDto(discountCardDao.update(discountCard, id).get());
        } else {
            throw new ParameterNotFoundException("Карта отсутствует в базе!");
        }
    }

    @Override
    public void remove(Integer id) {
        Optional<DiscountCard> optionalProduct = discountCardDao.findById(id);
        if (optionalProduct.isPresent()) {
            discountCardDao.delete(id);
        } else {
            throw new ParameterNotFoundException("Карта отсутствует в базе!");
        }
    }
}
