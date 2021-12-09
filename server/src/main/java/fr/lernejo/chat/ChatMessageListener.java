package fr.lernejo.chat;

import org.springframework.stereotype.Component;

@Component
public class ChatMessageListener {

    public final ChatMessageRepository repository;

    public ChatMessageListener(ChatMessageRepository chatMessageRepository) {
        repository = chatMessageRepository;
    }

    public void onMessage(String message) {
        repository.addChatMessage(message);
    }
    }

