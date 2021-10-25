package com.example.demo.LineEntity;


public class Event {
    private String replyToken;
    private String type;
    private String mode;
    private long timestamp;
    private Source source;
    private LineMessage message;

    public String getReplyToken() {
        return replyToken;
    }

    public void setReplyToken(String replyToken) {
        this.replyToken = replyToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public LineMessage getMessage() {
        return message;
    }

    public void setMessage(LineMessage message) {
        this.message = message;
    }
}
