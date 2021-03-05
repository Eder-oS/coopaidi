package com.dominio.models;

import javax.persistence.*;

@Entity
@Table(name = "libro2_tbl")
public class Libro2 {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "fk_escrito")
    private Escrito escrito;
}
