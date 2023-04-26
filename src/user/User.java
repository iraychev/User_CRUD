package user;

import exception.InvalidEmailException;
import exception.InvalidPasswordException;
import exception.InvalidUsernameException;
import util.InputValidator;

public class User {
    private final int id;
    private final String username;
    private final String password;
    private final String email;

    private User(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public static User createUser(int id, String username, String password, String email)
            throws InvalidUsernameException, InvalidPasswordException, InvalidEmailException {
        validateInput(username, password, email);
        return new User(id, username, password, email);
    }

    public static User createUser(String username, String password, String email)
            throws InvalidUsernameException, InvalidPasswordException, InvalidEmailException {
        return createUser(0, username, password, email);
    }

    private static void validateInput(String username, String password, String email)
            throws InvalidUsernameException, InvalidPasswordException, InvalidEmailException {
        InputValidator.validateUsername(username);
        InputValidator.validatePassword(password);
        InputValidator.validateEmail(email);

    }
    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "| " +
                "id=" + id +
                " | username='" + username+
                " | password='" + password+
                " | email='" + email+
                " |";
    }
}
