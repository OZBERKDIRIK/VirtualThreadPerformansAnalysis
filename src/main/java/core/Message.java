package core;

import core.User;
import java.time.LocalDateTime;

public class Message {
    private User sender;
    private User receiver;
    private String content;
    private LocalDateTime timestamp;

    public Message(User sender, User receiver, String content) {
        this.sender = sender;
        this.receiver = receiver;
        this.content = content;
        this.timestamp = LocalDateTime.now();
    }

    public User getSender() {
        return sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public String getContent() {
        return content;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "[" + timestamp + "] " + sender.getName() + " ➝ " + receiver.getName() + ": " + content;
    }
}
