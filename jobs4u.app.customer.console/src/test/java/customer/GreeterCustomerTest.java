package customer;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.containsString;

class GreeterCustomerTest {

    private GreeterCustomer greeter;

    @BeforeEach
    void init() {
        greeter = new GreeterCustomer();
    }

    @DisplayName("Say hello to Customer")
    @Test
    void sayHello() {
        MatcherAssert.assertThat(greeter.sayHello(), containsString("Welcome to the Customer App!"));
    }
}