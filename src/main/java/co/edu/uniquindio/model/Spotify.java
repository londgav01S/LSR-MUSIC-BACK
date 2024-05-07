package co.edu.uniquindio.model;


import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "spoti")
public class Spotify implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;

    private String name;


}
