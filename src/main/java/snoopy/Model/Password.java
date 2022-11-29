package snoopy.Model;

public class Password {
    private String password;

    public Password(String password) {
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public Boolean validPassword(String s) {
        return s.equals(getPassword());
    }
}
