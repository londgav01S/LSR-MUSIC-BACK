package co.edu.uniquindio.model;

import jakarta.persistence.*;

public class Author {

    private Long id;

    private String code;

    private String name;

    private String nationality;


    private boolean isGroup;



    public Author(String code, String name, String nationality, boolean isGroup) {
        this.code = code;
        this.name = name;
        this.nationality = nationality;
        this.isGroup = isGroup;
    }

    public Author() {

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public boolean isGroup() {
        return isGroup;
    }

    public void setGroup(boolean group) {
        isGroup = group;
    }

}
