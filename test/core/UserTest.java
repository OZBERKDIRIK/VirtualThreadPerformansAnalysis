package core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import core.User;
import core.Message;


public class UserTest {
    @Test
    public void testMessageCreation() {
        User sender = new User("u1", "Özberk");
        User receiver = new User("u2", "Test");

        core.Message message = new Message(sender, receiver, "Merhaba!");

        assertEquals(sender, message.getSender());
        assertEquals(receiver, message.getReceiver());
        assertEquals("Merhaba!", message.getContent());
        assertNotNull(message.getTimestamp());
    }

    @Test
    public void testMessageToString() {
        User sender = new User("u1", "Özberk");
        User receiver = new User("u2", "Test");
        Message message = new Message(sender, receiver, "Selam");

        String result = message.toString();
        assertTrue(result.contains("Özberk"));
        assertTrue(result.contains("Test"));
        assertTrue(result.contains("Selam"));
    }
}
