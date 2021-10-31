package org.example.domain.kernel.event;

import lombok.Getter;

import java.time.Clock;
import java.time.Instant;
import java.util.UUID;

@Getter
public class DomainEvent {

    private final UUID eventID;
    private final Instant timestamp;

    public DomainEvent() {
        this.eventID = UUID.randomUUID();
        this.timestamp = Instant.now(Clock.systemUTC());
    }
}
