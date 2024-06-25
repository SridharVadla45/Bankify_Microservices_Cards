package com.Bankify.Cards.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ResponseDTO {

    private HttpStatus Status;
    private String responseMsg;

}
