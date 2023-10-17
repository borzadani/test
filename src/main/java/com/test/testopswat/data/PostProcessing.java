package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PostProcessing {
    @JsonProperty("actions_failed")
    private String actionsFailed;
    @JsonProperty("actions_ran")
    private String actionsRan;
    @JsonProperty("converted_destination")
    private String convertedDestination;
    @JsonProperty("converted_to")
    private String convertedTo;
    @JsonProperty("copy_move_destination")
    private String copyMoveDestination;

    public String getActionsFailed() {
        return actionsFailed;
    }

    public void setActionsFailed(String actionsFailed) {
        this.actionsFailed = actionsFailed;
    }

    public String getActionsRan() {
        return actionsRan;
    }

    public void setActionsRan(String actionsRan) {
        this.actionsRan = actionsRan;
    }

    public String getConvertedDestination() {
        return convertedDestination;
    }

    public void setConvertedDestination(String convertedDestination) {
        this.convertedDestination = convertedDestination;
    }

    public String getConvertedTo() {
        return convertedTo;
    }

    public void setConvertedTo(String convertedTo) {
        this.convertedTo = convertedTo;
    }

    public String getCopyMoveDestination() {
        return copyMoveDestination;
    }

    public void setCopyMoveDestination(String copyMoveDestination) {
        this.copyMoveDestination = copyMoveDestination;
    }

    @Override
    public String toString() {
        return "PostProcessing{" +
                "actionsFailed='" + actionsFailed + '\'' +
                ", actionsRan='" + actionsRan + '\'' +
                ", convertedDestination='" + convertedDestination + '\'' +
                ", convertedTo='" + convertedTo + '\'' +
                ", copyMoveDestination='" + copyMoveDestination + '\'' +
                '}';
    }
}
