package com.rohitkashyap.HelpingHand.User;

public class UserPersonal {

    String Name1, UserName1, Email1, Password1;

    public UserPersonal(String name1, String userName1, String email1, String password1) {
        this.Name1 = name1;
        this.UserName1 = userName1;
        this.Email1 = email1;
        this.Password1 = password1;
    }

    public String getName1() {
        return Name1;
    }

    public void setName1(String name1) {
        Name1 = name1;
    }

    public String getUserName1() {
        return UserName1;
    }

    public void setUserName1(String userName1) {
        UserName1 = userName1;
    }

    public String getEmail1() {
        return Email1;
    }

    public void setEmail1(String email1) {
        Email1 = email1;
    }

    public String getPassword1() {
        return Password1;
    }

    public void setPassword1(String password1) {
        Password1 = password1;
    }
}
