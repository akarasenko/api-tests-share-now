package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FrontRightDoor {
 @JsonProperty("doorstatusfrontright")
    private Status status;

    public boolean isItemOpen () {
        return this.status.isItemOpen;
    }

    public String getTimestamp () {
        return this.status.timestamp;
    }
}
