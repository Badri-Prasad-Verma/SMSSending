package com.EmailSendingAPI.service;

import com.sendgrid.helpers.mail.objects.TrackingSettings;

public class TrackingSettingsBuilder {
    private EmailClickTrackingSetting clickTrackingSetting;
    private EmailOpenTrackingSetting openTrackingSetting;

    public TrackingSettingsBuilder setClickTrackingSetting(EmailClickTrackingSetting clickTrackingSetting) {
        this.clickTrackingSetting = clickTrackingSetting;
        return this;
    }

    public TrackingSettingsBuilder setOpenTrackingSetting(EmailOpenTrackingSetting openTrackingSetting) {
        this.openTrackingSetting = openTrackingSetting;
        return this;
    }

    public TrackingSettings build() {
        TrackingSettings trackingSettings = new TrackingSettings();
        trackingSettings.setClickTrackingSetting(clickTrackingSetting);
        trackingSettings.setOpenTrackingSetting(openTrackingSetting);
        return trackingSettings;
    }
}
