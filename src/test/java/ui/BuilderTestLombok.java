package ui;

import builders.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuilderTestLombok {

    @Test
    void testUserBuilder() {
        User user = User.builder()
                .username("alice")
                .email("alice@example.com")
                .age(28)
                .build();

        assertEquals("alice", user.getUsername());
        assertEquals("alice@example.com", user.getEmail());
        assertEquals(28, user.getAge());
    }
}
