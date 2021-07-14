package ru.iteco.decorator.chat;

import ru.iteco.decorator.chat.api.Chat;
import ru.iteco.decorator.message.Message;

public class SimpleChat implements Chat {

    private Message message;

    @Override
    public void send(Message message) {
        this.message = message;
    }

    @Override
    public Message receive() {
        return message != null ? message : null;
    }
}
