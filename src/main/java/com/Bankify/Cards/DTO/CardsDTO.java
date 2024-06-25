package com.Bankify.Cards.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Schema(
        name = "Card",
        description = "schema hold card details"
)
public class CardsDTO {

    @Pattern(regexp = "[1-9][0-9]{9}", message = "Enter valid mobileNumber")
    @NotEmpty
    @Schema(example = "9988855645")
    private String mobileNumber;

    @Pattern(regexp = "[0-9]{10}", message = "cardNumber is not valid ")
    @Schema(example = "9988855645")
    private String cardNumber;

    @NotEmpty(message = "card type cannot be null or empty ")
    @Schema(example = "DebitCard")
    private String cardType;

    @Schema(example = "600000")
    private int totalLimit;

    @Schema(example = "100000")
    private int amountUsed;

    @Schema(example = "500000")
    private int availableAmount;

}
