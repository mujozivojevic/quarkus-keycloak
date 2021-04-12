package org.rest.entity.dto;

public class UserDto {
    private Integer id;
    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getId() {return this.id;}

    public void setId(Integer id) {this.id = id;}
}
