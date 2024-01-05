package pt.iade.ricardopereira.qrity_admin.models;

public class UserItem {
   private int user_id;

   private String username;

   private String password;

    public UserItem(int id, String username, String password){

        this.username = username;

        this.password = password;

        this.user_id = id;
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

}
