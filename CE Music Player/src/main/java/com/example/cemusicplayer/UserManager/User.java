package com.example.cemusicplayer.UserManager;

public class User {
    private String UserName;
    private String Email;
    private String Province;
    private String Password;

    public String getProvince() {
        return Province;
    }

    public void setProvince(String province) {
        Province = province;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public void CreateAccount(String userName,String email,String Province,String Password){
        System.out.println("create account");

    }

    public void Login(String email,String password){
        System.out.println("login");

    }

    public void VerifyPassword(String userName, String password){
        System.out.println("correct password");

    }
    public void VerifyEmail(String userName,String password){
        System.out.println("correct email");

    }
    public void VerifySameAccount(String userName,String email,String Password){
        System.out.println("same");

    }

}
