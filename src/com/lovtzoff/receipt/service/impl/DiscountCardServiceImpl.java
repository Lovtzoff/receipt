package com.lovtzoff.receipt.service.impl;

import com.lovtzoff.receipt.data.DataReader;
import com.lovtzoff.receipt.exception.ParameterNotFoundException;
import com.lovtzoff.receipt.model.DiscountCard;
import com.lovtzoff.receipt.service.DiscountCardService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.lovtzoff.receipt.constants.Constants.SEPARATOR;

/**
 * Реализация интерфейса DiscountCardService.
 *
 * @author Ловцов Алексей
 * @see DiscountCardService
 */
public class DiscountCardServiceImpl implements DiscountCardService {

    /**
     * Считыватель данных.
     */
    private final DataReader dataReader;

    /**
     * Конструктор нового сервиса для скидочной карты, в который передается считыватель данных.
     *
     * @param dataReader считыватель данных
     * @see DiscountCardServiceImpl#DiscountCardServiceImpl(DataReader)
     */
    public DiscountCardServiceImpl(DataReader dataReader) {
        this.dataReader = dataReader;
    }

    //------------------------------------------------------------------------------------------------

    @Override
    public DiscountCard findOneById(Integer id) {
        for (DiscountCard discountCard : findAll()) {
            if (discountCard.getId().equals(id)) {
                return discountCard;
            }
        }
        return new DiscountCard();
    }

    @Override
    public List<DiscountCard> findAll() {
        List<String> lineList = dataReader.getDiscountCard();
        try {
            if (!lineList.isEmpty()) {
                List<DiscountCard> discountCardList = new ArrayList<>(lineList.size());
                for (String line : lineList) {
                    String[] array = line.split(SEPARATOR);
                    discountCardList.add(
                            new DiscountCard(
                                    Integer.parseInt(array[0]),         //id DiscountCard
                                    Integer.parseInt(array[1])          //Discount
                            )
                    );
                }
                return discountCardList;
            }
            throw new ParameterNotFoundException("Ошибка чтения списка скидочных карт!");
        } catch (ParameterNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return Collections.emptyList();
    }
}
