package com.example.demo.LinePushMessageEntity;

import java.util.List;

public class SendPushData {
    private String to;
    private List<PushMessage> messages;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<PushMessage> getMessages() {
        return messages;
    }

    public void setMessages(List<PushMessage> messages) {
        this.messages = messages;
    }
}
