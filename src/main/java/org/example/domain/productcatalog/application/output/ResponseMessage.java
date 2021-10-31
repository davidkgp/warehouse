package org.example.domain.productcatalog.application.output;


import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class ResponseMessage {

    private final String timestamp;
    private final String message;

    public ResponseMessage(String message) {
        this.message = message;
        this.timestamp = ZonedDateTime
                .now( ZoneId.systemDefault() )
                .format( DateTimeFormatter.ofPattern( "uuuu.MM.dd.HH.mm.ss" ) );
    }
}
