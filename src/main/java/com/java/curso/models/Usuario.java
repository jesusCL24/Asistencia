package com.java.curso.models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter @Column(name = "id")
    private long id;
    @Getter @Setter @Column(name = "nombre")
    private String nombre;
    @Getter @Setter @Column(name = "appaterno")
    private String appaterno;
    @Getter @Setter @Column(name = "apmaterno")
    private String apmaterno;
    @Getter @Setter @Column(name = "CI")
    private long CI;
    @Getter @Setter @Column(name = "contrasena")
    private String contrasena;

//descargar la dependencia lombok
}
