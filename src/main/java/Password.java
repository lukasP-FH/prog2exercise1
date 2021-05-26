public class Password {
    private final String pass;

    public Password(String password) {
        this.pass = password;
    }

    public boolean checkPassword() {
        return checkPasswordLength();
    }


    public boolean checkPasswordLength() {
        return (8 <= pass.length() && pass.length() <= 25);
    }
}