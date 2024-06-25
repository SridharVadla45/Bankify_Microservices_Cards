package com.Bankify.Cards.DTO;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CardsDTO {

    @Pattern(regexp = "[1-9][0-9]{9}", message = "Enter valid mobileNumber")
    @NotEmpty
    private String mobileNumber;

    @Pattern(regexp = "[0-9]{10}", message = "cardNumber is not valid ")
    private String cardNumber;

    @NotEmpty(message = "card type cannot be null or empty ")
    private String cardType;

    private int totalLimit;

    private int amountUsed;

    private int availableAmount;

}
