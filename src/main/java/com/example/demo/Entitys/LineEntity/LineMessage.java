package com.example.demo.Entitys.LineEntity;

import java.util.List;

public class LineMessage {
    private String id;
    private String type;
    private String text;
    private List<Emoji> emojis;
    private Mention mention;
    private ContentProvider contentProvider;
    private ImageSet imageSet;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public List<Emoji> getEmojis() {
        return emojis;
    }

    public void setEmojis(List<Emoji> emojis) {
        this.emojis = emojis;
    }

    public Mention getMention() {
        return mention;
    }

    public void setMention(Mention mention) {
        this.mention = mention;
    }

    public ContentProvider getContentProvider() {
        return contentProvider;
    }

    public void setContentProvider(ContentProvider contentProvider) {
        this.contentProvider = contentProvider;
    }

    public ImageSet getImageSet() {
        return imageSet;
    }

    public void setImageSet(ImageSet imageSet) {
        this.imageSet = imageSet;
    }
}
