package ru.iteco.decorator.message;

import java.util.Objects;

public class Message {

    private final String author;
    private final String address;
    private final String text;


    public Message(String author, String address, String text) {
        this.author = author;
        this.address = address;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public String getAddress() {
        return address;
    }

    public String getText() {
        return text;
    }

    public Message setAuthor(String author) {
        return new Message(author, address, text);
    }

    public Message setText(String text) {
        return new Message(author, address, text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(author, message.author) && Objects.equals(address, message.address) && Objects.equals(text, message.text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(author, address, text);
    }
}
