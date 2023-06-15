package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.clevertec.dto.DiscountCardDto;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.mapper.DiscountCardMapper;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.repository.DiscountCardRepository;
import ru.clevertec.service.DiscountCardService;

import java.util.List;
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
@Transactional(readOnly = true)
public class DiscountCardServiceImpl implements DiscountCardService {

    /**
     * Получение данных из базы.
     */
    private final DiscountCardRepository discountCardRepository;
    /**
     * Конвертация сущности в DTO и обратно.
     */
    private final DiscountCardMapper cardMapper;

    @Override
    public DiscountCardDto findOneById(Integer id) {
        return discountCardRepository.findById(id)
                .map(cardMapper::toDto)
                .orElseThrow(() -> new ParameterNotFoundException("Карта отсутствует в базе!"));
    }

    @Override
    public List<DiscountCardDto> findAll(String size, String page) {
        int pageSize = (size != null) ? Integer.parseInt(size) : DEFAULT_SIZE_PAGE;
        int pageNumber = (page != null) ? (Integer.parseInt(page) * pageSize) : DEFAULT_PAGE;

        List<DiscountCardDto> discountCards = discountCardRepository.findAll(PageRequest.of(pageNumber, pageSize))
                .stream()
                .map(cardMapper::toDto)
                .collect(Collectors.toList());
        if (!discountCards.isEmpty()) {
            return discountCards;
        } else {
            throw new ParameterNotFoundException("Ошибка чтения списка скидочных карт! База карт пуста!");
        }
    }

    @Override
    @Transactional
    public DiscountCardDto save(DiscountCardDto discountCardDto) {
        DiscountCard discountCard = cardMapper.toEntity(discountCardDto);
        return cardMapper.toDto(discountCardRepository.save(discountCard));
    }

    @Override
    @Transactional
    public DiscountCardDto update(DiscountCardDto discountCardDto, Integer id) {
        findOneById(id);
        DiscountCard discountCard = cardMapper.toEntity(discountCardDto);
        discountCard.setDiscount(id);
        return cardMapper.toDto(discountCardRepository.saveAndFlush(discountCard));
    }

    @Override
    @Transactional
    public void remove(Integer id) {
        findOneById(id);
        discountCardRepository.deleteById(id);
    }
}
