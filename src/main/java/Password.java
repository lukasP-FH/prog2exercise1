public class Password {
    private final String pass;

    public Password(String password) {
        this.pass = password;
    }

    public boolean checkPassword() {
        return (pass != null && checkPasswordLength() && checkPasswordLetters() && checkPasswordNumbers());
    }


    public boolean checkPasswordLength() { return (8 <= pass.length() && pass.length() <= 25);    }

    public boolean checkPasswordLetters() { return pass.matches("^(?=.*[a-z])(?=.*[A-Z]).+$");    }

    public boolean checkPasswordNumbers() { return pass.matches(".*\\d.*");    }

    public boolean checkPasswordSpecialChars() { return pass.matches("^(?:[\\d\\w]*[()#$?!%/@][\\d\\w]*)+$");    }
}
