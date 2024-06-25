package com.Bankify.Cards.Service;

import com.Bankify.Cards.DTO.CardsDTO;
import org.springframework.stereotype.Service;

@Service
public interface ICardsService {

    void createCard(String mobileNumber);

    CardsDTO getCard(String mobileNumber);

    void deleteCard(String mobileNumber);

    void updateCard(String mobileNumber, CardsDTO cardsDTO);

}
