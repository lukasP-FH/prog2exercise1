import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordTest {

    @Test
    @DisplayName("Check Password Length between 8 and 25 characters")
    public void testPasswordLength(){
        Password p = new Password("password");
        assertTrue(p.checkPasswordLength(), "Password should be between 8 and 25 characters!");
    }

    @Test
    @DisplayName("Check Password Length too short")
    public void testPasswordLengthTooShort(){
        Password p = new Password("pass");
        assertFalse(p.checkPasswordLength(), "Password too short!");
    }

    @Test
    @DisplayName("Check Password Length too long")
    public void testPasswordLengthTooLong(){
        Password p = new Password("passwordIsToLongLOL1234567890");
        assertFalse(p.checkPasswordLength(), "Password too long!");
    }

}
