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

    public boolean checkPasswordSpecialChars() { return pass.matches("^(?:[\\d\\w]*[()#$?!%/@][\\d\\w]*)+$");    }

    public boolean checkPasswordExtraNumbers() {
        int last = 99; int repeatcount = 0; int contcount = 0;
        for ( int i = 0; i < pass.length(); i++ ){
            if ( repeatcount>=3 || contcount>=3){
                return false;
            }
            if ( last == Character.getNumericValue(pass.charAt(i)) ){
                repeatcount++;
            } else {
                repeatcount = 0;
            }
            if ( last+1 == Character.getNumericValue(pass.charAt(i)) || last-1 == Character.getNumericValue(pass.charAt(i)) ){
                contcount++;
            } else {
                contcount = 0;
            }
            last = Character.getNumericValue(pass.charAt(i));
        }
        return true;
    }
}
