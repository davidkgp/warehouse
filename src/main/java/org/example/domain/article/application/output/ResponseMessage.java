package org.example.domain.article.application.output;


import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
@Getter
public class ResponseMessage {

    private String timestamp;
    private String message;

    public ResponseMessage(String message) {
        this.message = message;
        this.timestamp = ZonedDateTime
                .now(ZoneId.systemDefault())
                .format(DateTimeFormatter.ofPattern("uuuu.MM.dd.HH.mm.ss"));
    }
}
