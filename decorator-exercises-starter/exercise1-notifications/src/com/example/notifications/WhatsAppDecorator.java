package com.example.notifications;

public class WhatsAppDecorator extends NotifierDecorator {
    private final String waUser;

    public WhatsAppDecorator(Notifier wrapped, String waUser) {
        super(wrapped);
        this.waUser = waUser;
    }

    @Override
    public void notify(String text) {
        // Simulate sending WhatsApp message
        System.out.println("[WHATSAPP -> " + waUser + "]: " + text);
        super.notify(text);
    }
}
