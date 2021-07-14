package ru.iteco.decorator.chat.api;

import ru.iteco.decorator.message.Message;

public abstract class ChatDecorator implements Chat {

    private final Chat chat;

    protected ChatDecorator(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void send(Message message) {
        if (chat != null) {
            chat.send(message);
        }
    }

    @Override
    public Message receive() {
        return chat != null ? chat.receive() : null;
    }
}
