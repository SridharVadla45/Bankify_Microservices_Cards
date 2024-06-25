package com.Bankify.Cards.Service;

import com.Bankify.Cards.Constants.CardServiceConstants;
import com.Bankify.Cards.DTO.CardsDTO;
import com.Bankify.Cards.Entity.Card;
import com.Bankify.Cards.Exception.CardAlreadyExistException;
import com.Bankify.Cards.Exception.ResourceNotFoundException;
import com.Bankify.Cards.Mapper.CardMapper;
import com.Bankify.Cards.Repository.CardsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class CardServiceImpl implements ICardsService {

    private CardsRepository cardsRepository;

    @Override
    public void createCard(String mobileNumber) {

        Optional<Card> cardOptional = cardsRepository.findByMobileNumber(mobileNumber);
        if (cardOptional.isPresent()) {
            throw new CardAlreadyExistException("Card Already exists with provided MobileNumber : " + mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));

    }

    @Override
    public CardsDTO getCard(String mobileNumber) {
        Card card=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException(CardServiceConstants.CARD,"MobileNumber",mobileNumber));
        CardsDTO cardsDTO= CardMapper.mapToCardDTO(card,new CardsDTO());
        return cardsDTO;
    }

    @Override
    public void deleteCard(String mobileNumber) {
        Card card=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException(CardServiceConstants.CARD,"MobileNumber",mobileNumber));
        cardsRepository.deleteById(card.getCardId());
    }

    @Override
    public void updateCard(String mobileNumber, CardsDTO cardsDTO) {
        Card card=cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(()->new ResourceNotFoundException(CardServiceConstants.CARD,"MobileNumber",mobileNumber));
        card.setCardType(cardsDTO.getCardType());
        card.setTotalLimit(cardsDTO.getTotalLimit());
        card.setAvailableAmount(card.getTotalLimit()-card.getAmountUsed());
        cardsRepository.save(card);
    }

    private Card createNewCard(String mobileNumber) {
        Card card = new Card();
        card.setCardNumber(generateCardNumber());
        card.setCardType(CardServiceConstants.CARD_TYPE);
        card.setTotalLimit(60000);
        card.setAvailableAmount(60000);
        card.setAmountUsed(card.getTotalLimit() - card.getAvailableAmount());
        card.setMobileNumber(mobileNumber);
        card.setCreatedAt(LocalDate.now());
        card.setCreatedBy(mobileNumber);
        return card;
    }

    private String generateCardNumber() {
        Long cardNumber = 1000000000L + new Random().nextInt(900000000);
        return cardNumber.toString();
    }
}
