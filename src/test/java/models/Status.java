package models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Status {

    @JsonProperty("value")
    public boolean isItemOpen;

    @JsonProperty("timestamp")
    public String timestamp;

    public Status () {
        this.isItemOpen = false;
        this.timestamp = "";
    }
}
