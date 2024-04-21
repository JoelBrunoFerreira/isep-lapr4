package candidate;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;

class GreeterCandidateTest {

    private GreeterCandidate greeter;

    @BeforeEach
    void init() {
        greeter = new GreeterCandidate();
    }
    @DisplayName("Say hello to Candidate")
    @Test
    void sayHello() {
        MatcherAssert.assertThat(greeter.sayHello(), containsString("Welcome to the Candidate App!"));
    }
}