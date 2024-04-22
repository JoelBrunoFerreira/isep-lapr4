package backoffice;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;

class GreeterBackofficeTest {

    private GreeterBackoffice greeter;

    @BeforeEach
    void init() {
        greeter = new GreeterBackoffice();
    }
    @DisplayName("Say hello to Backoffice")
    @Test
    void sayHello() {
        MatcherAssert.assertThat(greeter.sayHello(), containsString("Welcome to the Backoffice App!"));
    }
}