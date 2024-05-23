package web.service;

import java.util.HashMap;
import java.util.Map;

/**
 * Business logic to handle login functions.
 */

public class LoginService {
    // Simulating a user database with username, password, and date of birth
    private static final Map<String, UserCredentials> userDatabase = new HashMap<>();

    static {
        // Initializing with some sample users
        userDatabase.put("ahsan", new UserCredentials("ahsan_pass", "1990-01-10"));
        userDatabase.put("deelaka", new UserCredentials("deelaka_pass", "1997-02-20"));
    }

    /**
     * Static method that checks if login is successful based on username, password, and dob.
     *
     * @param username the username of the user
     * @param password the password of the user
     * @param dob the date of birth of the user in yyyy-mm-dd format
     * @return true if the login is successful, false otherwise
     */
    public static boolean login(String username, String password, String dob) {
        UserCredentials credentials = userDatabase.get(username);

        if (credentials != null && credentials.getPassword().equals(password) && credentials.getDob().equals(dob)) {
            return true;
        }

        return false;
    }

    /**
     * Private inner class to represent user credentials.
     */
    private static class UserCredentials {
        private String password;
        private String dob;

        public UserCredentials(String password, String dob) {
            this.password = password;
            this.dob = dob;
        }

        public String getPassword() {
            return password;
        }

        public String getDob() {
            return dob;
        }
    }
}
