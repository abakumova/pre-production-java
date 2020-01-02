package com.viktoriia_abakumova.task9.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    private String responseMessage;
    private int responseCode;
}
