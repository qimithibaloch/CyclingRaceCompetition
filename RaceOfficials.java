import java.util.Objects;

public class RaceOfficials {
    private String username;
    private String password;

    public RaceOfficials(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean login(String enteredUsername, String enteredPassword) {
        return Objects.equals(enteredUsername, username) && Objects.equals(enteredPassword, password);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
