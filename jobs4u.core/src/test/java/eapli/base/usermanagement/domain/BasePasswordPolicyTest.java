package eapli.base.usermanagement.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BasePasswordPolicyTest {
    String password;
    @BeforeEach
    public void init() {
        password = BasePasswordPolicy.generatePassword();
    }

    @DisplayName("Testing password length")
    @Test
    public void testGeneratedPasswordLength() {
        assertEquals(8, password.length(), "Generated password length should be 8");
    }

    @DisplayName("Test if password contains uppercase letter")
    @Test
    public void testUppercaseLetters() {
        assertTrue(password.matches(".*[A-Z].*"), "Password should contain at least one uppercase letter");
    }

    @DisplayName("Test if password contains lowercase letter")
    @Test
    public void testLowercaseLetters() {
        assertTrue(password.matches(".*[a-z].*"), "Password should contain at least one lowercase letter");
    }

    @DisplayName("Test if password contains numbers")
    @Test
    public void testNumbers() {
        assertTrue(password.matches(".*\\d.*"), "Password should contain at least one number");
    }

    @DisplayName("Test if password contains special characters")
    @Test
    public void testSpecialCharacters() {
        assertTrue(password.matches(".*[^A-Za-z0-9].*"), "Password should contain at least one special character");
    }
}