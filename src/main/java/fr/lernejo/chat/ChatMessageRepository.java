package fr.lernejo.chat;

import java.util.*;

public class ChatMessageRepository {

    List<String> messageList = new LinkedList<>();

    public void addChatMessage(String message){
        messageList.add(message);
    }

    public List<String> getLastTenMessages(){
        return messageList.subList(Math.max(messageList.size() - 10,0), messageList.size());
    }
}
