package ru.iteco.decorator.chat;

import ru.iteco.decorator.chat.api.AnonymousChat;
import ru.iteco.decorator.chat.api.Chat;

public class AnonymousChatImpl extends AnonymousChat {

    public AnonymousChatImpl(Chat chat) {
        super(chat);
    }

    @Override
    protected String hideAuthor(String author) {
        return "Anonymous";
    }
}
