package com.Bankify.Cards.Controller;


import com.Bankify.Cards.Constants.CardServiceConstants;
import com.Bankify.Cards.DTO.CardsDTO;
import com.Bankify.Cards.DTO.ResponseDTO;
import com.Bankify.Cards.Service.ICardsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class CardsController {


    private ICardsService iCardsService;

    @PostMapping("/create/{mobileNumber}")
    public ResponseEntity<ResponseDTO> createCard(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobileNumber") String mobileNumber) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(HttpStatus.CREATED, CardServiceConstants.CREATE_RESPONSE_MSG + mobileNumber));
    }

    @GetMapping("/getCard/{mobileNumber}")
    public ResponseEntity<CardsDTO> getCardDetials(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobile number") String mobileNumber) {
        CardsDTO cardsDTO = iCardsService.getCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDTO);
    }

    @DeleteMapping("/delete/{mobileNumber}")
    public ResponseEntity<ResponseDTO> deleteCardDetails(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobile number") String mobileNumber) {
        iCardsService.deleteCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, CardServiceConstants.DELETE_RESPONSE_MSG));
    }

    @PutMapping("/update/{mobileNumber}")
    public ResponseEntity<ResponseDTO> updateCardDetails(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobile number") String mobileNumber, @Valid @RequestBody CardsDTO cardsDTO) {
        iCardsService.updateCard(mobileNumber, cardsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, CardServiceConstants.UPDATE_RESPONSE_MSG));
    }
}
