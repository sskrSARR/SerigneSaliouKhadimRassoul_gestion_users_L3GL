package entity;

public class User {
    private int id;
    private String email;
    private String password;
    private String passwordHashed;
    private  int idRole;


    //Constructeurs

    public User(int id, String email, String password, String passwordHashed, int idRole) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.passwordHashed = passwordHash();
        this.idRole = idRole;
    }

    public User() {
    }

    //getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordHashed() {
        return passwordHashed;
    }

    public void setPasswordHashed(String passwordHashed) {
        this.passwordHashed = passwordHashed;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    //methodes

    public String passwordHash() {
        StringBuilder passHash = new StringBuilder();

        for (int i = 0; i < password.length(); i++) {
            char character = password.charAt(i);
            char maskedCharacter = (char) (character + 1);
            passHash.append(maskedCharacter);
        }

        return passHash.toString();
    }

    public String passwordDehash(String passwordHashed) {
        StringBuilder PasswordInitial = new StringBuilder();

        for (int i = 0; i < passwordHashed.length(); i++) {
            char CharacterMask = passwordHashed.charAt(i);
            char Character = (char) (CharacterMask - 1);
            PasswordInitial.append(Character);
        }

        return PasswordInitial.toString();
    }

}
