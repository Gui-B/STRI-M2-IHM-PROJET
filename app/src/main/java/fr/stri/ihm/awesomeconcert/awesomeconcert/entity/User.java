package fr.stri.ihm.awesomeconcert.awesomeconcert.entity;

/**
 * Created by Guillaume BOULIC & Rémi BARBASTE on 28/11/2016.
 */

public class User {
    private String userName;
    private String name;
    private String lastName;
    private String mail;
    private String passwd;

    public User(String userName, String name, String lastName, String mail, String passwd) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
        this.passwd = passwd;
    }

    public boolean isPasswdMatch(String passwd) {
        return this.passwd.equals(passwd);
    }

    public String getUserName() {
        return userName;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMail() {
        return mail;
    }

    public String getPasswd() {
        return passwd;
    }

    public void updateUser(String userName, String name, String lastName, String mail) {
        this.userName = userName;
        this.name = name;
        this.lastName = lastName;
        this.mail = mail;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
