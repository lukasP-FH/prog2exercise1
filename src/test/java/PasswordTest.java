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
        assertFalse(p.checkPasswordLetters(), "Password needs Uppercase Letters!");
    }

    @Test
    @DisplayName("Check Password no Lowercase")
    public void testPasswordNoLowercase(){
        Password p = new Password("EVERYTHINGBIG");
        assertFalse(p.checkPasswordLetters(), "Password needs Lowercase Letters!");
    }

    @Test
    @DisplayName("Check Password for Numbers")
    public void testPasswordNumbers(){
        Password p = new Password("123445123323");
        assertTrue(p.checkPasswordNumbers(), "Password needs Numbers!");
    }

    @Test
    @DisplayName("Check Password for no Numbers")
    public void testPasswordNoNumbers(){
        Password p = new Password("NoNumbers");
        assertFalse(p.checkPasswordNumbers(), "Password needs Numbers!");
    }

    @Test
    @DisplayName("Check Password for Special Chars")
    public void testPasswordSpecialChars(){
        Password p = new Password("onlyContains()#$?!%/@");
        assertTrue(p.checkPasswordSpecialChars(), "Password needs atleast one of these ()#$?!%/@");
    }

    @Test
    @DisplayName("Check Password for other Special Chars")
    public void testPasswordOtherSpecialChars(){
        Password p = new Password("????d-:,;special");
        assertFalse(p.checkPasswordSpecialChars(), "Password has wrong Special Chars!");
    }

    @Test
    @DisplayName("Check Password for more Numbers")
    public void testPasswordExtraNumbers(){
        Password p = new Password("124533791");
        assertTrue(p.checkPasswordExtraNumbers(), "Password needs different Numbers!");
    }

    @Test
    @DisplayName("Check Password for more repeating Numbers")
    public void testPasswordExtraNumbersRepeating(){
        Password p = new Password("11111111111111");
        assertFalse(p.checkPasswordExtraNumbers(), "Password needs different Numbers!");
    }

    @Test
    @DisplayName("Check Password for continuous Numbers")
    public void testPasswordExtraNumbersContinuous(){
        Password p = new Password("12345678910");
        assertFalse(p.checkPasswordExtraNumbers(), "Password needs different Numbers!");
    }

    @Test
    @DisplayName("Check Password for extended Numbers")
    public void testPasswordExtraNumbers2(){
        Password p = new Password("123");
        assertFalse(p.checkPasswordExtraNumbers(), "Password needs different Numbers!");
    }

    @Test
    @DisplayName("Check Password for extended Numbers")
    public void testPasswordExtraNumbers3(){
        Password p = new Password("111");
        assertFalse(p.checkPasswordExtraNumbers(), "Password needs different Numbers!");
    }

    @Test
    @DisplayName("Check Password for extended Numbers")
    public void testPasswordExtraNumbers4(){
        Password p = new Password("abc");
        assertTrue(p.checkPasswordExtraNumbers(), "Password needs different Numbers!");
    }

    @Test
    @DisplayName("Check Password")
    public void testPassword(){
        Password p = new Password("You!1255)(");
        assertTrue(p.checkPassword(), "Password needs to be different!");
    }

    @Test
    @DisplayName("Check Password False")
    public void testPassword2(){
        Password p = new Password("You!1255)(-");
        assertFalse(p.checkPassword(), "Password needs to be different!");
    }
}
