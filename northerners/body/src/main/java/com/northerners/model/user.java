//user, own 1 inventory
package com.northerners.model;
import org.springframework.stereotype.Component;

@Component
public class user {
    private int userId;
    private String userName;
    private String password;
    private inventory userInvent;

    public int getUserId() {
        return userId;
    }

    public String getPassword() {
        return password;
    }

    public String getUserName() {
        return userName;
    }

    public inventory getUserInvent() {
        return userInvent;
    }

    public void setAccountID(int userId) {
        this.userId = userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUserInvent(inventory userInvent) {
        this.userInvent = userInvent;
    }
}

