package edu.zubkov.dto;

import java.util.List;

public class UserDto {
    private long id;
    private String name;
    private String surname;
    private String profession;
    private String username;
    private String password;
    private List<String> roles;

    public UserDto() {
    }

    public UserDto(long id, String name, String surname, String profession, String username, String password, List<String> roles) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.profession = profession;
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
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

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}