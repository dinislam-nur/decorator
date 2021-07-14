package ru.iteco.decorator.chat.api;

import ru.iteco.decorator.message.Message;

public interface Chat {

    void send(Message message);

    Message receive();

}
