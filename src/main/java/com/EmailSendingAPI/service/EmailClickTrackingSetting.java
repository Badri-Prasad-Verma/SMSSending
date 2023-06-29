package com.EmailSendingAPI.service;

import com.sendgrid.helpers.mail.objects.ClickTrackingSetting;

public class EmailClickTrackingSetting extends ClickTrackingSetting {
    private boolean enable;

    public EmailClickTrackingSetting(boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
