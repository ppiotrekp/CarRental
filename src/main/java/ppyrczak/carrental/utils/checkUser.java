package ppyrczak.carrental.utils;

import ppyrczak.carrental.entities.User;

public class checkUser {
    private User user;

    public boolean userIdentification(String userEmail, String userPassword) {
        if (user.getEmail() == userEmail && user.getPassword() == userPassword) {
            return true;
        } else {
            return false;
        }
    }
}
