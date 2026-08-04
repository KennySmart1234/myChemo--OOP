package ng.myChemo.data.models;

public class User {
    private String username;
    private String password;
    private String fullName;
    private long userId;
    private boolean isLoggedIn;

    public String getUsername() {

        return username;
    }

    public void setUsername(String username) {

        this.username = username;
    }

    public String getPassword() {

        return password;
    }

    public void setPassword(String password) {

        this.password = password;
    }

    public String getFullName() {

        return fullName;
    }

    public void setFullName(String fullName) {

        this.fullName = fullName;
    }

    public long getUserId() {

        return userId;
    }

    public void setUserId(long userId) {

        this.userId = userId;
    }

    public boolean isLoggedIn() {

        return isLoggedIn;
    }
    public void setLoggedIn(boolean loggedIn) {

        isLoggedIn = loggedIn;
    }

}
