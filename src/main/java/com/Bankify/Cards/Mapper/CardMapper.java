package com.Bankify.Cards.Mapper;

import com.Bankify.Cards.DTO.CardsDTO;
import com.Bankify.Cards.Entity.Card;
import org.springframework.stereotype.Component;

@Component
public class CardMapper {

    public static Card mapToCard(CardsDTO cardsDTO, Card card) {
        card.setCardNumber(cardsDTO.getCardNumber());
        card.setCardType(cardsDTO.getCardType());
        card.setMobileNumber(cardsDTO.getMobileNumber());
        card.setTotalLimit(cardsDTO.getTotalLimit());
        card.setAmountUsed(cardsDTO.getAmountUsed());
        card.setAvailableAmount(cardsDTO.getAvailableAmount());
        return card;
    }

    public static CardsDTO mapToCardDTO(Card card, CardsDTO cardsDTO) {
        cardsDTO.setCardNumber(card.getCardNumber());
        cardsDTO.setCardType(card.getCardType());
        cardsDTO.setMobileNumber(card.getMobileNumber());
        cardsDTO.setTotalLimit(card.getTotalLimit());
        cardsDTO.setAvailableAmount(card.getAvailableAmount());
        cardsDTO.setAmountUsed(card.getAmountUsed());
        return cardsDTO;
    }
}
