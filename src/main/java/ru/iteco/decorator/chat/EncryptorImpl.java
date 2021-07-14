package ru.iteco.decorator.chat;

import ru.iteco.decorator.chat.api.Chat;
import ru.iteco.decorator.chat.api.Encryptor;

public class EncryptorImpl extends Encryptor {

    private final static String SALT = "Зашифровано: ";

    public EncryptorImpl(Chat chat) {
        super(chat);
    }

    @Override
    protected String encode(String text) {
        return SALT + text;
    }

    @Override
    protected String decode(String text) {
        return text.matches("^" + SALT + ".*") ?
                text.replace(SALT, "") :
                text;
    }
}
