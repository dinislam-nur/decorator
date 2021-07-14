package ru.iteco.decorator.chat.api;

import ru.iteco.decorator.message.Message;

public abstract class Encryptor extends ChatDecorator {

    protected Encryptor(Chat chat) {
        super(chat);
    }

    @Override
    public void send(Message message) {
        super.send(message.setText(encode(message.getText())));
    }

    @Override
    public Message receive() {
        final Message received = super.receive();
        return received != null ?
                received.setText(decode(received.getText())) :
                null;
    }

    protected abstract String encode(String text);

    protected abstract String decode(String text);
}
