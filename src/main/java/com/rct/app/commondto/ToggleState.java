package com.rct.app.commondto;

import java.util.UUID;

public class ToggleState {
    private UUID id;
    private Boolean toggle;

    public ToggleState(UUID id, Boolean toggle) {
        this.id = id;
        this.toggle = toggle;
    }

    public UUID getId() {
        return id;
    }

    public Boolean getToggle() {
        return toggle;
    }
}
