package pt.iade.ricardopereira.qrity.models;

public class UserItem {
    private int user_id;

    private String username;

    private String password;

    private int user_level;

    public UserItem(int id, String username, String password, int user_level){

        this.username = username;

        this.password = password;

        this.user_id = id;

        this.user_level = user_level;


       // this.user_level = getDefaultUserLevel();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

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

    public int getUser_level() {
        return user_level;
    }

    public void setUser_level(int user_level) {
        this.user_level = user_level;
    }
    /*private int getDefaultUserLevel(){

        return 0;
    }*/
}

