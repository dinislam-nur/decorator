package ru.iteco.decorator.chat.api;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.iteco.decorator.chat.AnonymousChatImpl;
import ru.iteco.decorator.chat.EncryptorImpl;
import ru.iteco.decorator.chat.SimpleChat;
import ru.iteco.decorator.message.Message;

import static org.junit.jupiter.api.Assertions.*;

class ChatTest {

    private Chat chat;
    private static Message message;

    @BeforeAll
    static void beforeAll() {
        message = new Message("author", "address", "test");
    }

    @BeforeEach
    void setUp() {
        chat = new SimpleChat();
    }

    @Test
    public void testSimpleChat() {
        chat.send(message);
        final Message received = chat.receive();
        assertEquals(message, received);
    }

    @Test
    public void testAnonymousChat() {
        chat = new AnonymousChatImpl(chat);
        chat.send(message);
        final Message received = chat.receive();
        assertEquals(message.getAddress(), received.getAddress());
        assertEquals(message.getText(), received.getText());
        assertNotEquals(message.getAuthor(), received.getAuthor());
        assertEquals("Anonymous", received.getAuthor());
    }

    @Test
    public void testEncryptor() {
        final Chat simpleChat = chat;
        chat = new EncryptorImpl(chat);
        chat.send(message);
        final Message received = chat.receive();
        final Message receivedSimpleMessage = simpleChat.receive();
        assertNotEquals(message.getText(), receivedSimpleMessage.getText());
        assertEquals("Зашифровано: " + message.getText(), receivedSimpleMessage.getText());
        assertEquals(message, received);
    }

    @Test
    public void testAnonAndEncrypted() {
        final AnonymousChatImpl anonymousChat = new AnonymousChatImpl(chat);
        chat = new EncryptorImpl(anonymousChat);
        chat.send(message);
        final Message received = chat.receive();
        final Message receivedAnonMessage = anonymousChat.receive();
        assertNotEquals(message.getText(), receivedAnonMessage.getText());
        assertEquals("Зашифровано: " + message.getText(), receivedAnonMessage.getText());
        assertEquals(message.getAddress(), received.getAddress());
        assertEquals(message.getText(), received.getText());
        assertNotEquals(message.getAuthor(), received.getAuthor());
        assertEquals("Anonymous", received.getAuthor());
    }

}