package ru.clevertec.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.repository.DiscountCardRepository;
import ru.clevertec.service.DiscountCardService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

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
    private final DiscountCardRepository discountCardRepository;

    @Override
    public DiscountCard findOneById(Integer id) {
        return discountCardRepository.findById(id).orElse(new DiscountCard());
    }

    @Override
    public List<DiscountCard> findAll(String size, String page) {
        int pageSize = (size != null) ? Integer.parseInt(size) : DEFAULT_SIZE_PAGE;
        int pageNumber = (page != null) ? (Integer.parseInt(page) * pageSize) : DEFAULT_PAGE;

        try {
            List<DiscountCard> discountCards = discountCardRepository.findAll(pageSize, pageNumber);
            if (!discountCards.isEmpty()) {
                return discountCards;
            }
            throw new ParameterNotFoundException("Ошибка чтения списка скидочных карт! База карт пуста!");
        } catch (ParameterNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return Collections.emptyList();
    }

    @Override
    public DiscountCard save(DiscountCard discountCard) {
        return discountCardRepository.add(discountCard);
    }

    @Override
    public DiscountCard update(DiscountCard discountCard, Integer id) {
        Optional<DiscountCard> optionalProduct = discountCardRepository.findById(id);
        if (optionalProduct.isPresent()) {
            return discountCardRepository.update(discountCard, id).get();
        }
        throw new ParameterNotFoundException("Карта отсутствует в базе!");
    }

    @Override
    public void remove(Integer id) {
        discountCardRepository.delete(id);
    }
}
