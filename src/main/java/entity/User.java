package entity;

import dao.Identified;

/**
 * Created by roski on 4/22/16.
 */
public class User implements Identified<Integer> {

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public Integer getId() {
        return null;
    }

    private String username;
    private String password;
    private String role;
}
