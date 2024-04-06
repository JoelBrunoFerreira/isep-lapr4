package candidate;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;

class GreeterCandidateTest {

    private Greeter_Candidate greeter;

    @BeforeEach
    void init() {
        greeter = new Greeter_Candidate();
    }
    @DisplayName("Say hello to Candidate")
    @Test
    void sayHello() {
        MatcherAssert.assertThat(greeter.sayHello(), containsString("Welcome to the Candidate App!"));
    }
}