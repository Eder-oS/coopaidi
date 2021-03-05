package com.dominio.models;

import javax.persistence.*;

@Entity
@Table(name = "escrito_tbl")
public class Escrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne(mappedBy = "escrito")
    private Libro2 libro2;
}
