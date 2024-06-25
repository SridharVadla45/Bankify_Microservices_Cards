package com.Bankify.Cards.DTO;

import com.Bankify.Cards.Constants.CardServiceConstants;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Schema(name = "Response", description = "schema hold response object")
public class ResponseDTO {

    @Schema(example = "201 CREATED ")
    private HttpStatus Status;
    @Schema(example = CardServiceConstants.CREATE_RESPONSE_MSG)
    private String responseMsg;

}
