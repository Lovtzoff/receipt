package ru.clevertec.service.impl;

import ru.clevertec.dao.DiscountCardDao;
import ru.clevertec.exception.ParameterNotFoundException;
import ru.clevertec.model.DiscountCard;
import ru.clevertec.service.DiscountCardService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Реализация интерфейса DiscountCardService.
 *
 * @author Ловцов Алексей
 * @see DiscountCardService
 */
public class DiscountCardServiceImpl implements DiscountCardService {

    /**
     * Получение данных из базы.
     */
    private final DiscountCardDao discountCardDao;

    /**
     * Конструктор нового сервиса для скидочной карты, в который передаются данные из базы.
     *
     * @param discountCardDao считыватель данных
     * @see DiscountCardServiceImpl#DiscountCardServiceImpl(DiscountCardDao)
     */
    public DiscountCardServiceImpl(DiscountCardDao discountCardDao) {
        this.discountCardDao = discountCardDao;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public DiscountCard findOneById(Integer id) {
        return discountCardDao.findById(id).orElse(new DiscountCard());
    }

    @Override
    public List<DiscountCard> findAll() {
        try {
            List<DiscountCard> discountCards = discountCardDao.findAll();
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
        return discountCardDao.add(discountCard);
    }

    @Override
    public DiscountCard update(DiscountCard discountCard, Integer id) {
        Optional<DiscountCard> optionalProduct = discountCardDao.findById(id);
        if (optionalProduct.isPresent()) {
            return discountCardDao.update(discountCard, id).get();
        }
        throw new ParameterNotFoundException("Карта отсутствует в базе!");
    }

    @Override
    public void remove(Integer id) {
        discountCardDao.delete(id);
    }
}
