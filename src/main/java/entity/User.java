package entity;

import dao.Identified;

/**
 * Created by roski on 4/22/16.
 */
public class User implements Identified<Integer> {
    private String username;
    private String password;
    private String group;

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

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public Integer getId() {
        return null;
    }
}
