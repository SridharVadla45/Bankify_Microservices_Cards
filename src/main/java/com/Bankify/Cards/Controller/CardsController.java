package com.Bankify.Cards.Controller;


import com.Bankify.Cards.Constants.CardServiceConstants;
import com.Bankify.Cards.DTO.CardsDTO;
import com.Bankify.Cards.DTO.ResponseDTO;
import com.Bankify.Cards.Service.ICardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Cards Service",
        description = "Card service exposing all CRUD operations related to card "
)
public class CardsController {


    private ICardsService iCardsService;

    @Operation(
            description = "These enpoint creates new card by taking mobileNumber from user"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP STATUS : CREATED"
    )

    @PostMapping("/create/{mobileNumber}")
    public ResponseEntity<ResponseDTO> createCard(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobileNumber") String mobileNumber) {
        iCardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseDTO(HttpStatus.CREATED, CardServiceConstants.CREATE_RESPONSE_MSG + mobileNumber));
    }

    @Operation(
            description = "These enpoint fetchs card details by taking mobileNumber from user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS : SUCCESS"
    )
    @GetMapping("/getCard/{mobileNumber}")
    public ResponseEntity<CardsDTO> getCardDetials(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobile number") String mobileNumber) {
        CardsDTO cardsDTO = iCardsService.getCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cardsDTO);
    }

    @Operation(
            description = "These enpoint deletes  card by taking mobileNumber from user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS : SUCCESS"
    )

    @DeleteMapping("/delete/{mobileNumber}")
    public ResponseEntity<ResponseDTO> deleteCardDetails(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobile number") String mobileNumber) {
        iCardsService.deleteCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, CardServiceConstants.DELETE_RESPONSE_MSG));
    }


    @Operation(
            description = "These enpoint updates  card by taking mobileNumber from user"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP STATUS : SUCCESS"
    )
    @PutMapping("/update/{mobileNumber}")
    public ResponseEntity<ResponseDTO> updateCardDetails(@PathVariable @Pattern(regexp = "[1-9][0-9]{9}", message = "enter a valid mobile number") String mobileNumber, @Valid @RequestBody CardsDTO cardsDTO) {
        iCardsService.updateCard(mobileNumber, cardsDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDTO(HttpStatus.OK, CardServiceConstants.UPDATE_RESPONSE_MSG));
    }
}
