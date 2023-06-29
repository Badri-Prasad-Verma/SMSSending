package com.EmailSendingAPI.request;

public class EmailRequest {
    private String recipientEmail;
    private String subject;
    private String content;
    private String recipient;

    public String getRecipientEmail() {
        return recipientEmail;
    }

    public void setRecipientEmail(String recipientEmail) {
        this.recipientEmail = recipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRecipient() {
        // Perform any validation or modification logic for the recipient email
        // For example, you can trim any leading or trailing spaces
        return recipient.trim();
    }

}

