import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordTest {

    @Test
    @DisplayName("Nullchecker")
    public void testPasswordNull(){
        Password p = new Password(null);
        assertFalse(p.checkPassword(), "Password should not be null!");
    }

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

    @Test
    @DisplayName("Check Password A-Z and a-z")
    public void testPasswordUppercaseAndLowercase(){
        Password p = new Password("BIGandSMALL");
        assertTrue(p.checkPasswordLetters(), "Password needs Upper- and Lowercase Letters!");
    }

    @Test
    @DisplayName("Check Password no Uppercase")
    public void testPasswordNoUppercase(){
        Password p = new Password("everythingsmall");
        assertFalse(p.checkPasswordLetters(), "Password needs Uppercase Letters");
    }

    @Test
    @DisplayName("Check Password no Lowercase")
    public void testPasswordNoUppercase(){
        Password p = new Password("EVERYTHINGBIG");
        assertFalse(p.checkPasswordLetters(), "Password needs Lowercase Letters");
    }



}
