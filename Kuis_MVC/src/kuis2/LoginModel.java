
package kuis2;

public class LoginModel {
    private String username, password;
    //constructor
    public void setLoginModel(String uusername, String ppassword){
        this.username = uusername;
        this.password = ppassword;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
}
