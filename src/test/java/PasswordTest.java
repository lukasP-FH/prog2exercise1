import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
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
        assertTrue(p.checkPasswordLength(), "Password should be between 8 and 25 characters!");
    }

}
