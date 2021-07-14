package ru.iteco.decorator.chat.api;

import ru.iteco.decorator.message.Message;

public abstract class AnonymousChat extends ChatDecorator {

    protected AnonymousChat(Chat chat) {
        super(chat);
    }

    @Override
    public void send(Message message) {
        super.send(message.setAuthor(hideAuthor(message.getAuthor())));
    }

    protected abstract String hideAuthor(String author);
}
