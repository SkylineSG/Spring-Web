package com.crud.tasks.domain;


public class Mail {

    private String mailTo;
    private String subject;
    private String message;
    private String toCc;

    public String getMailTo() {
        return mailTo;
    }

    public String getSubject() {
        return subject;
    }

    public String getMessage() {
        return message;
    }

    public String getToCc() {
        return toCc;
    }


    public Mail(String mailTo, String subject, String message, String toCc) {
        this.mailTo = mailTo;
        this.subject = subject;
        this.message = message;
        this.toCc = toCc;
    }
}
