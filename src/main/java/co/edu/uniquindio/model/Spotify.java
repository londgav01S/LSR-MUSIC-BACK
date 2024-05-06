package co.edu.uniquindio.model;


import jakarta.persistence.*;

@Entity
@Table (name = "spoti")
public class Spotify {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;


}
