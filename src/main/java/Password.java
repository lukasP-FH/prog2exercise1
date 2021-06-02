public class Password {
    private final String pass;

    public Password(String password) {
        this.pass = password;
    }

    public boolean checkPassword() {
        return (pass != null && checkPasswordLength() && checkPasswordLetters() && checkPasswordNumbers() && checkPasswordSpecialChars() && checkPasswordExtraNumbers());
    }


    public boolean checkPasswordLength() { return (8 <= pass.length() && pass.length() <= 25);    }

    public boolean checkPasswordLetters() { return pass.matches("^(?=.*[a-z])(?=.*[A-Z]).+$");    }

    public boolean checkPasswordNumbers() { return pass.matches(".*\\d.*");    }

    //Regex considers _ as a word character
    //Other Regex: ^(?:[a-zA-Z0-9]*[()#$?!%\/@][a-zA-Z0-9]*)+$ or ^(?:[^\W_]*[()#$?!%\/@][^\W_]*)+$
    public boolean checkPasswordSpecialChars() { return pass.matches("^(?:\\w*[()#$?!%/@]\\w*)+$");    }

    public boolean checkPasswordExtraNumbers() {
        int last = 99; int repeatcount = 0; int contcount = 0;
        for ( char i : pass.toCharArray() ){
            if ( Character.isDigit(i) ) {
                if (repeatcount >= 2 || contcount >= 2) {
                    return false;
                }
                if (last == Character.getNumericValue(i)) {
                    repeatcount++;
                } else {
                    repeatcount = 0;
                }
                if (last + 1 == Character.getNumericValue(i) || last - 1 == Character.getNumericValue(i)) {
                    contcount++;
                } else {
                    contcount = 0;
                }
                last = Character.getNumericValue(i);
            }
        }
        return repeatcount < 2 && contcount < 2;
    }
}
