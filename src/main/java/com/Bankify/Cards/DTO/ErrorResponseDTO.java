package com.Bankify.Cards.DTO;

import lombok.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ErrorResponseDTO {

    private HttpStatus status;
    private LocalDate timeStamp;
    private String errorMsg;
    private String apiPath;


}
