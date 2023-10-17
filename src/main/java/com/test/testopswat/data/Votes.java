package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Votes {
    @JsonProperty("up")
    private int up;
    @JsonProperty("down")
    private int down;

    public int getUp() {
        return this.up;
    }

    public void setUp(int up) {
        this.up = up;
    }

    public int getDown() {
        return this.down;
    }

    public void setDown(int down) {
        this.down = down;
    }
}
