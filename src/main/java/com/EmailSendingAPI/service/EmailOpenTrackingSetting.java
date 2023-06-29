package com.EmailSendingAPI.service;

import com.sendgrid.helpers.mail.objects.OpenTrackingSetting;

public class EmailOpenTrackingSetting extends OpenTrackingSetting {
    private boolean enable;

    public EmailOpenTrackingSetting(boolean enable) {
        this.enable = enable;
    }

    public boolean isEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }
}
