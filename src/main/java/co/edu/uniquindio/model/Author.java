package co.edu.uniquindio.model;

import jakarta.persistence.*;


@Entity
@Table (name = "AUTHOR")
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "nationality")
    private String nationality;

    @Column(name = "is_grupo_musical")
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
