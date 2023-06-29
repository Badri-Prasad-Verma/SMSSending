package com.EmailSendingAPI.service;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import com.sendgrid.helpers.mail.objects.TrackingSettings;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    private final SendGrid sendGrid;

    @Value("${email.sender}")
    private String emailSender;

    @Autowired
    public EmailService(SendGrid sendGrid) {
        this.sendGrid = sendGrid;
    }

    public void sendEmail(String recipient, String subject, String content) {
        Email from = new Email(emailSender);
        Email to = new Email(recipient);
        Content emailContent = new Content("text/plain", content);

        Mail mail = new Mail(from, subject, to, emailContent);

        // Enable click and open tracking
        TrackingSettings trackingSettings = new TrackingSettingsBuilder()
                .setClickTrackingSetting(new EmailClickTrackingSetting(true))
                .setOpenTrackingSetting(new EmailOpenTrackingSetting(true))
                .build();

        mail.setTrackingSettings(trackingSettings);

        // Send email
        // Send email
        try {
            Request request = new Request();
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());

            Response response = sendGrid.api(request);
            if (response.getStatusCode() == HttpStatus.OK.value()) {
                System.out.println("Email sent to " + recipient);
            } else {
                System.out.println("Failed to send email to " + recipient + ": " + response.getBody());
            }
        } catch (Exception e) {
            System.out.println("Failed to send email to " + recipient + ": " + e.getMessage());
        }

    }
}

